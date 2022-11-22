package model.game;

import model.tile.Stack;

import java.util.ArrayList;

public class Rule {
    public static void gamePlaying(ArrayList<String> tileList, ArrayList<String> playerOneTileList, ArrayList<String> playerTwoTileList){

    }

    public static void gameEndingCheck(ArrayList<String> tileList, ArrayList<String> playerOneTileList, ArrayList<String> playerTwoTileList) {
        int tileListSize = Stack.stackSize(tileList);
        int playerOneListSize = Stack.stackSize(playerOneTileList);
        int playerTwoListSize = Stack.stackSize(playerTwoTileList);

        // 타일 리스트에 더 이상 타일이 없어 게임을 끝내야 하는 경우
        if(tileListSize == 0 && (playerOneListSize != 0 && playerTwoListSize != 0)){
            //TODO END 01. 타일 없음
        }

        // 유저1이 타일을 다 내서 게임을 끝내야 하는 경우
        else if(playerOneListSize == 0){
            //TODO END 02. 유저1의 타일 없음
        }

        // 유저2가 타일을 다 내서 게임을 끝내야 하는 경우
        else if(playerTwoListSize == 0){
            //TODO END 03. 유저2의 타일 없음
        }

        else {

        }
    }
}
