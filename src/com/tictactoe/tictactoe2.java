package com.tictactoe;

import java.util.Scanner;

public class tictactoe2 {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        /*-------------输入玩家人数-----------*/
        int player_num = 0;
        while(true){
            System.out.println("请输入玩家的个数(3~10人):");
            if(input.hasNextInt()){
                player_num=input.nextInt();
                if(player_num<3){
                    System.out.println("【玩家人数过少，请重新输入！】");
                }else if(player_num>10){
                    System.out.println("【玩家人数过多，请重新输入！】");
                }else{
                    break;
                }
            }else{
                System.out.println("【输入数据类型错误，请重新输入！】");
                input.next();
            }
        }
        /*------------输入连续棋子个数--------*/
        int piece_num = 0;
        while(true){
            System.out.println("请输入赢家连续棋子的个数（最少为3，最大为玩家人数+1）：");
            if(input.hasNextInt()){
                piece_num = input.nextInt();
                if(piece_num < 3){
                    System.out.println("【连续棋子数过少，请重新输入！】");
                }else if(piece_num > player_num+1){
                    System.out.println("【连续棋子数不能超过玩家人数+1，请重新输入！】");
                }else{
                    break;
                }
            }else{
                System.out.println("【输入数据类型错误，请重新输入！】");
                input.next();
            }
        }

        /*-------------初始化棋盘---------------*/
        int size = player_num + 1; //棋盘的大小
        Board board = new Board();
        board.createBoard(size); //创建棋盘
        board.drawBoard(size); //绘制初始棋盘

        /*-------------初始化玩家------------*/
        char player[] = new char[player_num];
        for(int i=0; i<player_num;i++){
            int temp = 97+i;  //准备由int向char进行转换
            player[i]= (char) temp;  //用字母a~j表示0号~9号玩家（根据题目要求，最多10人，第10人为j）
        }
        /*--------------开始下棋-------------*/
        GameLogic logic = new GameLogic();
        int play_i=0; //从0号玩家开始
        while (true) {

            logic.makeAMove(board,player[play_i]);  //下棋，更新棋盘
            board.drawBoard(size); //绘制新棋盘
            if (logic.isWon(player[play_i], board,piece_num,size)) {  //判断第i号玩家是否获胜
                System.out.println("玩家"+player[play_i]+"获胜");
                System.exit(1);
            }
            else if (logic.isDraw(board,size)) {  //判断是否平局
                System.out.println("平局");
                System.exit(2);
            }

            if(play_i<player_num-1){
                play_i++; //下一个玩家
            }else {
                play_i=0;  //又轮到0号玩家
            }
        }
    }

}


