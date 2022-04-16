package com.lichen.github.website.server.common.dal.setup;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.Map;

@Data
public class R2dbcConnectionProperties {

    private String driver;

    private String host;

    private int port;

    private String user;

    private String password;

    private String database;

    private String connectionTimeout;

    private boolean ssl;

    @NestedConfigurationProperty
    private Pool pool;

    private Map<String, Object> properties;

    @Data
    public static class Pool {

        private int initialSize = 10;

        private int maxSize = 10;

    }
}
