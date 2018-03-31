package com.sapient.game.model;

import java.util.Random;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class Board {

    private int[][] board;
    private Ship ship;
    //int[][] ships = new int[3][2];


    public int[][] getBoard() {
        return board;
    }

    public Ship getShip() {
        return ship;
    }

    public Board(int[][] board, Ship ship) {
        this.board = board;
        this.ship = ship;
    }

    public void initBoard(){
        for(int row=0 ; row < 5 ; row++ )
            for(int column=0 ; column < 5 ; column++ )
                board[row][column]=-1;
    }

    public void showBoard(){
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();

        for(int row=0 ; row < 5 ; row++ ){
            System.out.print((row+1)+"");
            for(int column=0 ; column < 5 ; column++ ){
                if(board[row][column]==-1){
                    System.out.print("\t"+"~");
                }else if(board[row][column]==0){
                    System.out.print("\t"+"*");
                }else if(board[row][column]==1){
                    System.out.print("\t"+"X");
                }

            }
            System.out.println();
        }

    }
    public void initShips(){
        int[][] ships = ship.getShipLocation();
        Random random = new Random();

        for(int i=0 ; i < 3 ; i++){
            ships[i][0]=random.nextInt(5);
            ships[i][1]=random.nextInt(5);

            //let's check if that shot was already tried
            //if it was, just finish the do...while when a new pair was randomly selected
            for(int last=0 ; last < i ; last++){
                if( (ships[i][0] == ships[last][0])&&(ships[i][1] == ships[last][1]) )
                    do{
                        ships[i][0]=random.nextInt(5);
                        ships[i][1]=random.nextInt(5);
                    }while( (ships[i][0] == ships[last][0])&&(ships[i][1] == ships[last][1]) );
            }

        }
    }
}
