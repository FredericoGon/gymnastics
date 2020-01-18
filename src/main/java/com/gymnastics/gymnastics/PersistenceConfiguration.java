package com.gymnastics.gymnastics;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/gymnastics");
        builder.username("postgres");
        builder.password("postgres");
        return builder.build();
    }
}
