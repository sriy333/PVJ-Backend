package com.pvj.db;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfig {

    //@Value("${spring.datasource.url}")
    private String dbUrl = "jdbc:mysql://bdde21b7cf435e:9c6eeaa8@us-cdbr-east-04.cleardb.com/heroku_9bf29f35787134a?reconnect=true";

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
}