package com.sapient.game.service;

import com.sapient.game.dao.IBattleshipGameDao;
import com.sapient.game.memory.GameSession;
import com.sapient.game.model.Board;
import com.sapient.game.model.Player;
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
    public Board showStatus(long playerId) {
        return battleshipGameDao.showStatus(playerId);
    }

    @Override
    public void shoot(long playerId, long gameSessionId,Shot shot) {
        battleshipGameDao.shoot(playerId,gameSessionId,shot);
    }

    @Override
    public GameSession joinGame(Player player) {

        return battleshipGameDao.joinGame(player);
    }

    @Override
    public GameSession resetGame(long gameSessionId) {
        return battleshipGameDao.resetGame(gameSessionId);
    }
}
