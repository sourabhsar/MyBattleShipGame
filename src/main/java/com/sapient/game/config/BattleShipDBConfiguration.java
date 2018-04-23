package com.sapient.game.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Sourabh on 4/21/2018.
 */

@Configuration
@EnableWebMvc
@PropertySource(value = { "classpath:battleship.properties" })
public class BattleShipDBConfiguration {

    @Bean
    public DriverManagerDataSource dataSource(@Value("${battleship.dbconnection.driverclassname}") String driverClassName,
                                              @Value("${battleship.dbconnection.dbHostName}") String url,
                                              @Value("${battleship.dbconnection.username}") String username,
                                              @Value("${battleship.dbconnection.password}") String password) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
