package com.sapient.game.config;

import com.sapient.game.dao.BattleshipGameDaoImpl;
import com.sapient.game.dao.IBattleshipGameDao;
import com.sapient.game.model.Board;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Random;

/**
 * Created by Sourabh on 3/31/2018.
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.sapient.game.dao"})
public class BattleshipGameDaoConfig {

    @Bean
    public IBattleshipGameDao battleshipGameDao() {
        Board board = new Board(new int[5][5]);
        board.initBoard();
        board.initShips(new int[3][2]);
        return new BattleshipGameDaoImpl(board);
    }
}
