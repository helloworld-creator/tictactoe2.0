package com.tictactoe;

public class Board {
    private char[][] board ;

    //创建棋盘
    //Done!
    public void createBoard(int size){
        board = new char[size][size];  //创建初始棋盘，棋子默认为空
    }

    //绘制棋盘
    //Done!
    public void drawBoard(int size){
        for(int i=0; i< size; i++){  //最上面的线
            System.out.print(" ———");
        }
        System.out.print("\n");
        for (int i = 0; i < size; i++) { //每一列
            System.out.print("| ");
            for (int j = 0; j < size; j++)
                System.out.print(board[i][j] != '\0' ?  board[i][j] + " | ": "  | ");
            System.out.print("\n");
            for(int k=0; k< size; k++){  //最下面的线
                System.out.print(" ———");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
   }

   //玩家下棋后，改变棋盘数组board
   //Done!
    public void changeBoard(int row,int column,char player){
        board[row][column]=player;
    }

    //查看棋盘
    //Done!
    public char[][] getBoard() {
        return board;
    }
}
