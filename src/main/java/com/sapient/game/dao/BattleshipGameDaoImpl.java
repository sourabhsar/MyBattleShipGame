package com.sapient.game.dao;

import com.sapient.game.memory.GameSession;
import com.sapient.game.memory.Session;
import com.sapient.game.model.Board;
import com.sapient.game.model.Player;
import com.sapient.game.model.Ship;
import com.sapient.game.model.Shot;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class BattleshipGameDaoImpl extends AbstractDao implements IBattleshipGameDao {

    public BattleshipGameDaoImpl(Session session, DataSource dataSource) {
        super(session, dataSource);
    }

    @Override
    public Board showStatus(long playerId) {
        Player player = getSession().getPlayerMap().get(playerId);
        return player.getBoard();
    }

    @Override
    public void shoot(long playerId, long gameSessionId, Shot shot) {
        GameSession gameSession = getSession().getGameSessionsIdMap().get(gameSessionId);
        synchronized (gameSession) {
            if(gameSession.getPlayer2() == null) {
                throw new RuntimeException("waiting for 2nd player to join");
            }
            if (gameSession.isEnd()) {
                throw new RuntimeException("This game is ended, please restart");
            }
            Player player = null;
            if (gameSession.getPlayer1().getId() == playerId) {
                player = gameSession.getPlayer1();
            } else {
                player = gameSession.getPlayer2();
            }
            synchronized (player) {
                if (!player.isMyTurn()) {
                    throw new RuntimeException("This is not your turn");
                }

                player.setAttempt(player.getAttempt() + 1);
                player.setMyTurn(false);
                Player opponent = player.getOpponent();
                updateBoard(shot, opponent.getBoard().getShip().getShipLocation(), opponent.getBoard(),player,gameSession);
                if (gameSession.isEnd()) {
                    System.out.println("\n\n\nBattleship Java game finished! You hit 3 ships in " + player.getAttempt() + " attempts");
                    System.out.println("Winner is : "+ gameSession.getWinner().getName());
                    System.out.println("Please restart the game");
                    return;
                }
                opponent.setMyTurn(true);
            }
        }
    }

    /**
     * It checks if there is any available game session, if there any available game session is there the player will be joined as second player
     * otherwise the player will be joined as 1st player
     * @param player : player who joins a game session i.e. new game session as 1st player or existing game session as 2nd player
     * @return
     */
    @Override
    public synchronized GameSession joinGame(Player player) {
        GameSession gameSession = checkIfAnyGameSessionAvailable();
            if (gameSession != null) {
                player.setGameSessionId(gameSession.getGameSessionId());
                player.setOpponent(gameSession.getPlayer1());
                gameSession.setPlayer2(player);
                gameSession.getPlayer1().setOpponent(player);
            } else {
                gameSession = new GameSession();
                long gameSessionId = GameSession.geneRateGameSessionId();
                gameSession.setGameSessionId(gameSessionId);
                player.setGameSessionId(gameSessionId);
                gameSession.setPlayer1(player);
            }
            setUpPlayerBoard(player);
            getSession().addPLayers(player);
            getSession().addGameSessions(gameSession);
        return gameSession;
    }

    @Override
    public GameSession resetGame(long gameSessionId) {
        GameSession gameSession = getSession().getGameSessionsIdMap().get(gameSessionId);
        resetGame(gameSession.getPlayer1());
        resetGame(gameSession.getPlayer2());
        return gameSession;
    }

    private static void resetGame(Player player) {
        player.getBoard().initBoard();
        player.getBoard().initShips();
        player.setShotHit(0);
        player.setAttempt(0);
        player.setMyTurn(true);
    }

    private void setUpPlayerBoard(Player player) {
        Ship ship = new Ship(new int[3][2]);
        Board board = new Board(new int[5][5],ship);
        board.initBoard();
        board.initShips();
        player.setBoard(board);
    }

    /*
    Each game session holds only two players, if the second is null that means that game session is waiting for 2nd player to join,
    so we return that game session otherwise, we return null game session
     */
    private GameSession checkIfAnyGameSessionAvailable() {
        Set<Map.Entry<Long,GameSession>> entry;
        Iterator<Map.Entry<Long,GameSession>> iterator;
        GameSession gameSession = null;
        if(getSession().getGameSessionsIdMap().size() != 0) {
            entry = getSession().getGameSessionsIdMap().entrySet();
            iterator = entry.iterator();

            while (iterator.hasNext()) {
                gameSession = iterator.next().getValue();
                if(gameSession.getPlayer2() == null) {
                    return gameSession;
                }
            }
        }
        return null;
    }

    private static boolean hit(Shot shot, int[][] ships){

        for(int ship=0 ; ship<ships.length ; ship++){
            if((shot.getRow() - 1) == ships[ship][0] && (shot.getColumn() -1) == ships[ship][1]){
                System.out.printf("You hit a ship located in (%d,%d)\n",shot.getRow(),shot.getColumn());
                return true;
            }
        }
        return false;
    }

    private static void updateBoard(Shot shot, int[][] ships, Board board,Player player, GameSession gameSession){
        if(hit(shot,ships)) {
            board.getBoard()[shot.getRow() -1][shot.getColumn()-1] = 1;
            int hit = player.getShotHit() +1;
            player.setShotHit(hit);
            System.out.println("player " + player.getName() + " hit : " + hit);
            if(hit == 3) {
                gameSession.setWinner(player);
                gameSession.setEnd(true);
            }
        } else {
            board.getBoard()[shot.getRow()-1][shot.getColumn()-1] = 0;
        }
    }
}
