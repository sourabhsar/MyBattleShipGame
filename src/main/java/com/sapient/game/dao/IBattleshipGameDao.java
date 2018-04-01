package com.sapient.game.dao;

import com.sapient.game.memory.GameSession;
import com.sapient.game.model.Board;
import com.sapient.game.model.Player;
import com.sapient.game.model.Shot;

/**
 * Created by Sourabh on 3/31/2018.
 */
public interface IBattleshipGameDao {

    Board showStatus(long playerId);

    void shoot(long playerId, long gameSessionId, Shot shot);

    GameSession joinGame(Player player);

    GameSession resetGame(long gameSessionId);
}
