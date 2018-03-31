package com.sapient.game.service;

import com.sapient.game.model.Board;
import com.sapient.game.model.Shot;

/**
 * Created by Sourabh on 3/31/2018.
 */
public interface IBattleshipGameService {
    Board showStatus();

    void shoot(Shot shot);
}
