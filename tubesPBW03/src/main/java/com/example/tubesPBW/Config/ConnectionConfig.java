package com.example.tubesPBW.Config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionConfig {

    private final DataSource dataSource;

    public ConnectionConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public Connection connection() throws SQLException {
        return dataSource.getConnection();
    }
}
