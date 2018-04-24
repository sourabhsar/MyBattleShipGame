package com.sapient.game.config;

import com.sapient.game.dao.BattleshipGameDaoImpl;
import com.sapient.game.dao.IBattleshipGameDao;
import com.sapient.game.memory.Session;
import com.sapient.game.model.Board;
import com.sapient.game.model.Ship;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Random;

/**
 * Created by Sourabh on 3/31/2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.sapient.game.dao"})
public class BattleshipGameDaoConfig {

    @Bean
    public IBattleshipGameDao battleshipGameDao(DataSource dataSource) {
        return new BattleshipGameDaoImpl(Session.getInstance(),dataSource);
    }
}
