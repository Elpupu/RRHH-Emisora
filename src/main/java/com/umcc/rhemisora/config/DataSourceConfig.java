package com.umcc.rhemisora.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class DataSourceConfig {

    private Environment environment;
    @Autowired
    public DataSourceConfig(Environment environment){
        this.environment=environment;
    }
    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        String URL = "spring.datasource.jdbcUrl";
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        String USER = "spring.datasource.username";
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        String PASSWORD = "spring.datasource.password";
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        String DRIVER = "spring.datasource.driverClassName";
        driverManagerDataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty(DRIVER)));
        return driverManagerDataSource;
    }
}
