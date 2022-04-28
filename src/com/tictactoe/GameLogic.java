package com.tictactoe;
import java.util.Scanner;


public class GameLogic {
    private static Scanner input = new Scanner(System.in);

    //玩家下一个棋子，改变棋盘布局
    //Done!
    public void makeAMove(Board board, char player) {
        char[][] board2 = board.getBoard();     //获取棋盘目前状态
        boolean done = false;  //用来判断循环，用户第一次输入的是正确位置就一次循环；否则进入下一次
        do {
            System.out.print("玩家 " + player + " ：（行，列） = ");
            int row = input.nextInt();  //玩家输入棋子的行数
            int column = input.nextInt();  //玩家输入棋子的列数
            if (board2[row][column] == '\0') {
                board.changeBoard(row,column,player);  //玩家成功下了一棋！
                done = true;  //有位置就放下，跳出这个循环
            }
            else
                System.out.println("无效输入");  //玩家选择的位置已经有棋子了，重新下
        }
        while (!done);
    }

    //判断player是否赢了，返回true为赢
    //思路：仿照卷积核进行卷积的过程
    public boolean isWon(char player, Board board,int piece,int size) {
        char[][] board2 = board.getBoard();     //获取棋盘目前状态

        for(int row=0; row<=size-piece;row++){
            for(int col=0;col<=size-piece;col++){
                /*-----------------以piece×piece为大小的内部检查-------------*/
                //行相同
                for(int i=row;i<row+piece;i++){
                    for(int j=col;j<col+piece;j++){
                        if(player==board2[i][j]){
                            if(j==col+piece-1) return true; //找到满足条件的行
                        }else break;  //这一行不满足，跳出内循环，检查下一行
                    }
                }
                //列相同
                for(int j=col;j<col+piece;j++){
                    for(int i=row;i<row+piece;i++){
                        if(player==board2[i][j]){
                            if(i==row+piece-1) return true; //找到满足条件的列
                        }else break; //这一列不满足，检查下一列
                    }
                }
                //正对角线相同
                for(int k=0;k<piece;k++){
                    if(player==board2[row+k][col+k]){
                        if(row+k==row+piece-1) return true; //找到满足条件的正对角线
                    }else break; //正对角线不满足
                }
                //负对角线
                int row2=row+piece-1;
                int col2=col;
                for(int k=0;k<piece;k++){
                    if(player==board2[row2-k][col2+k]){
                        if(row2-k==row) return true; //找到满足条件的副对角线
                    }else break; //负对角线不满足
                }
            }
        }
        return false;
    }

    //判断是否平局：返回false为否，返回true为平局
    //Done!
    public boolean isDraw(Board board,int size) {
        char [][]board2 = board.getBoard();
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (board2[i][j] == '\0')
                    return false; //棋盘存在空白，未平局
        return true;
    }
}
