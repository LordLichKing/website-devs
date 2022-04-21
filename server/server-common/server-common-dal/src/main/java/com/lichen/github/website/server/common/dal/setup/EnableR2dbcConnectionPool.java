package com.lichen.github.website.server.common.dal.setup;

import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(R2dbcConnectionRegistrar.class)
public @interface EnableR2dbcConnectionPool {

    @AliasFor("value")
    String prefix() default "";

    @AliasFor("prefix")
    String value() default "";
}
