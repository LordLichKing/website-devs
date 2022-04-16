package com.lichen.github.website.server.common.dal.setup;

import io.r2dbc.pool.ConnectionPool;
import io.r2dbc.pool.ConnectionPoolConfiguration;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import lombok.Setter;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.Objects;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

public class R2dbcConnectionRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    @Setter
    private Environment environment;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {

        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(EnableR2dbcConnectionPool.class.getName());

        if (attributes == null) {
            throw new IllegalStateException("Unable to find attributes from EnableR2dbcConnectionPool annotation.");
        }

        String prefix = (String) attributes.get("prefix");
        if (ObjectUtils.isEmpty(prefix)) {
            throw new IllegalArgumentException("The prefix of EnableR2dbcConnectionPool should not be empty");
        }

        R2dbcConnectionProperties properties = getProperties(prefix);
        ConnectionFactory c  = createConnectionFactory(properties);

        registry.registerBeanDefinition("connectionFactory", BeanDefinitionBuilder.genericBeanDefinition(ConnectionFactory.class, () -> decoratePool(c, properties)).getBeanDefinition());
    }

    private R2dbcConnectionProperties getProperties(String prefix) {

        BindResult<R2dbcConnectionProperties> result = Binder.get(environment).bind(prefix, R2dbcConnectionProperties.class);
        if (result.isBound()) {
            return result.get();
        } else {
            throw new IllegalStateException("Unable to bind preifx'" + prefix + "' to R2dbcConnectionProperties.");
        }
    }

    private ConnectionFactory createConnectionFactory(R2dbcConnectionProperties properties) {

        return ConnectionFactories.get(ConnectionFactoryOptions.builder()
                .option(DRIVER, properties.getDriver())
                .option(HOST, properties.getHost())
                .option(USER, properties.getUser())
                .option(PORT, properties.getPort())
                .option(PASSWORD, properties.getPassword())
                .option(DATABASE, properties.getPassword())
                .build());
    }

    private ConnectionFactory decoratePool(ConnectionFactory connectionFactory, R2dbcConnectionProperties properties) {

        R2dbcConnectionProperties.Pool pool = properties.getPool();
        if (Objects.isNull(pool)) {
            return connectionFactory;
        }

        return new ConnectionPool(ConnectionPoolConfiguration.builder(connectionFactory)
                .initialSize(pool.getInitialSize())
                .maxSize(pool.getMaxSize())
                .build());
    }
}
