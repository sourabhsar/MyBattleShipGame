package com.sapient.game.service;

import com.sapient.game.dao.IBattleshipGameDao;
import com.sapient.game.model.Board;
import com.sapient.game.model.Shot;

import javax.inject.Inject;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class BattleshipGameServiceImpl implements IBattleshipGameService {

    private IBattleshipGameDao battleshipGameDao;

    @Inject
    public BattleshipGameServiceImpl(IBattleshipGameDao battleshipGameDao) {
        this.battleshipGameDao = battleshipGameDao;
    }

    @Override
    public Board showStatus() {
        return battleshipGameDao.showStatus();
    }

    @Override
    public void shoot(Shot shot) {
        battleshipGameDao.shoot(shot);
    }
}
