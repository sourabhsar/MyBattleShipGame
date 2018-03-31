package com.sapient.game.dao;

import com.sapient.game.model.Board;
import com.sapient.game.model.Shot;

import javax.inject.Inject;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class BattleshipGameDaoImpl implements IBattleshipGameDao {

    private Board board;
    private static int shotHit =0;
    private static int attempt =0;
    private static boolean end = false;

    @Inject
    public BattleshipGameDaoImpl(Board board) {
        this.board = board;
    }

    @Override
    public Board showStatus() {
        return board;
    }

    @Override
    public void shoot(Shot shot) {
        ++attempt;
        updateBoard(shot,board.getShip().getShipLocation(),board);
        if(end) {
            System.out.println("\n\n\nBattleship Java game finished! You hit 3 ships in "+attempt+" attempts");
            System.out.println("Please restart the game");
            return;
        }
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

    private static void updateBoard(Shot shot, int[][] ships, Board board){
        if(hit(shot,ships)) {
            board.getBoard()[shot.getRow() -1][shot.getColumn()-1] = 1;
            if(++shotHit == 3) {
                end = true;
            }
        } else {
            board.getBoard()[shot.getRow()-1][shot.getColumn()-1] = 0;
        }
    }
}
