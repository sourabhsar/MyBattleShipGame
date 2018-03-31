package com.sapient.game.config;

import com.sapient.game.dao.IBattleshipGameDao;
import com.sapient.game.service.BattleshipGameServiceImpl;
import com.sapient.game.service.IBattleshipGameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Sourabh on 3/31/2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.sapient.game.service"})
public class BattleshipGameServicesConfig {

    @Bean
    public IBattleshipGameService battleshipGameService(IBattleshipGameDao battleshipGameDao) {
        return new BattleshipGameServiceImpl(battleshipGameDao);
    }
}
