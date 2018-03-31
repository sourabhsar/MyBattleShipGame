package com.sapient.game.dao;

import com.sapient.game.model.Board;

import javax.inject.Inject;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class BattleshipGameDaoImpl implements IBattleshipGameDao {

    private Board board;

    @Inject
    public BattleshipGameDaoImpl(Board board) {
        this.board = board;
    }

    @Override
    public Board showStatus() {
        return board;
    }
}
