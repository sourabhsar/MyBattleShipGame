package com.sapient.game.memory;

import com.sapient.game.model.Player;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Sourabh on 3/31/2018.
 */
public final class Session {

    private static Map<Long,GameSession> gameSessionsIdMap = new ConcurrentHashMap<>();
    private static Map<Long,Player> playerMap = new ConcurrentHashMap<>();

    private static Session _instance;

    private Session() {}

    public static Session getInstance() {
        if(_instance == null) {
            _instance = new Session();
        }
        return _instance;
    }
    public void addGameSessions(GameSession gameSession) {
        gameSessionsIdMap.put(gameSession.getGameSessionId(),gameSession);
    }

    public void addPLayers(Player player) {
        playerMap.put(player.getId(),player);
    }

    public Map<Long, GameSession> getGameSessionsIdMap() {
        return gameSessionsIdMap;
    }

    public Map<Long, Player> getPlayerMap() {
        return playerMap;
    }
}
