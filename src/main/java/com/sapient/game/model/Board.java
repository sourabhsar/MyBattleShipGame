package com.sapient.game.model;

import java.util.Random;

/**
 * Created by Sourabh on 3/31/2018.
 */
public class Board {

    private int[][] board;
    //int[][] ships = new int[3][2];


    public int[][] getBoard() {
        return board;
    }

    public Board(int[][] board) {
        this.board = board;
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
    public void initShips(int[][] ships){
        Random random = new Random();

        for(int ship=0 ; ship < 3 ; ship++){
            ships[ship][0]=random.nextInt(5);
            ships[ship][1]=random.nextInt(5);

            //let's check if that shot was already tried
            //if it was, just finish the do...while when a new pair was randomly selected
            for(int last=0 ; last < ship ; last++){
                if( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) )
                    do{
                        ships[ship][0]=random.nextInt(5);
                        ships[ship][1]=random.nextInt(5);
                    }while( (ships[ship][0] == ships[last][0])&&(ships[ship][1] == ships[last][1]) );
            }

        }
    }
}
