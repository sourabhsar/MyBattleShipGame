package com.sapient.game.config;

import com.sapient.game.dao.BattleshipGameDaoImpl;
import com.sapient.game.dao.IBattleshipGameDao;
import com.sapient.game.model.Board;
import com.sapient.game.model.Ship;
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
        Ship ship = new Ship(new int[3][2]);
        Board board = new Board(new int[5][5],ship);
        board.initBoard();
        board.initShips();
        return new BattleshipGameDaoImpl(board);
    }
}
