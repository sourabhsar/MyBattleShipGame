package com.sapient.game.controller;

import com.sapient.game.memory.GameSession;
import com.sapient.game.model.Board;
import com.sapient.game.model.Player;
import com.sapient.game.model.Shot;
import com.sapient.game.service.IBattleshipGameService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by Sourabh on 3/31/2018.
 */
@RestController
public class BattleshipGameController {

    private IBattleshipGameService battleshipGameService;

    @Inject
    public BattleshipGameController(IBattleshipGameService battleshipGameService) {
        this.battleshipGameService = battleshipGameService;
    }

    @RequestMapping(value="player/{playerId}/status",method = GET)
    public Board showStatus(@PathVariable(value = "playerId") long playerId) {
        Board b = battleshipGameService.showStatus(playerId);
        b.showBoard();
        return b;
    }

    @RequestMapping(value = "player/{playerId}/gameSession/{gameSessionId}/shoot",method = POST)
    public View shoot(@PathVariable(value = "gameSessionId") long gameSessionId,
                      @PathVariable(value = "playerId") long playerId,
                      @RequestBody Shot shot) {
        battleshipGameService.shoot(playerId,gameSessionId,shot);
        return new RedirectView("/player/"+playerId+"/status",true,false);
    }

    @RequestMapping(value = "/joinGame",method = POST)
    public GameSession joinGame(@RequestBody Player player) {
        return battleshipGameService.joinGame(player);
    }

    @RequestMapping(value = "gameSession/{gameSessionId}/reset",method = PUT)
    public GameSession restartGame(@PathVariable(value = "gameSessionId") long gameSessionId) {
        return battleshipGameService.resetGame(gameSessionId);
    }
}
