package com.sapient.game.memory;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sapient.game.model.Player;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class GameSession {

    @JsonManagedReference
    private Player player1;

    @JsonManagedReference
    private Player player2;

    private Player winner;
    private long gameSessionId;
    private boolean end = false;

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public long getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(long gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public static long geneRateGameSessionId() {
        return System.currentTimeMillis();
    }
}
