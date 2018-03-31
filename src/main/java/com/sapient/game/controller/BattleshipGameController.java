package com.sapient.game.controller;

import com.sapient.game.model.Board;
import com.sapient.game.model.Shot;
import com.sapient.game.service.IBattleshipGameService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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

    @RequestMapping(value="/status",method = GET)
    public Board showStatus() {
        Board b = battleshipGameService.showStatus();
        b.showBoard();
        return b;
    }

    @RequestMapping(value = "/shoot",method = POST)
    public View shoot(@RequestBody Shot shot) {
        battleshipGameService.shoot(shot);
        return new RedirectView("/status",true,false);
    }
}
