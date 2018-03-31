package com.sapient.game.config;

import com.sapient.game.controller.BattleshipGameController;
import com.sapient.game.service.IBattleshipGameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Sourabh on 3/31/2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.sapient.game.controller"})
public class BattleshipGameWebAPIConfig extends WebMvcConfigurerAdapter {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BattleshipGameController battleshipGameController(IBattleshipGameService battleshipGameService) {
        return new BattleshipGameController(battleshipGameService);
    }
}
