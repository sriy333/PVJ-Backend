package com.pvj.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Component
public class JpaConfig extends HikariConfig {

    @Bean
    public DataSource dataSource() throws SQLException {
    	HikariDataSource config = new HikariDataSource();
    	config.setJdbcUrl("jdbc:mysql://bdde21b7cf435e:9c6eeaa8@us-cdbr-east-04.cleardb.com/heroku_9bf29f35787134a?reconnect=true");
        return config;
    }

}