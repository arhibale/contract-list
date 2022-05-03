package com.arhibale.server.repository.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariDataSourceConfigure {
    public static HikariDataSource getPostgres() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres?currentSchema=contracts");
        config.setUsername("postgres");
        config.setPassword("postgres");
        return new HikariDataSource(config);
    }
}
