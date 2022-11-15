package model.tile;

import model.game.Rule;

import java.util.ArrayList;
import java.util.Collections;

import static model.tile.Stack.stackSize;
import static model.tile.color.*;
import static model.tile.color.RESET;

public class Tile {
    public int tileNum;
    public tileColor color;

    public Tile(int tileNum, tileColor color){
        this.tileNum = tileNum;
        this.color = color;
    }

    public static void tileColorMatchAndAdd(ArrayList<String> tileList) {
        int i = 0;
        for(int r = 0; r<2; r++){
            for(tileColor tile : tileColor.values()){
                if(tile == tileColor.RED){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_RED + "R" + j + RESET);
                        i++;
                    }
                }

                if(tile == tileColor.YELLOW){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_YELLOW + "Y" + j + RESET);
                        i++;
                    }
                }

                if(tile == tileColor.BLUE){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_BLUE + "B" + j + RESET);
                        i++;
                    }
                }

                if(tile == tileColor.WHITE){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_WHITE + "W" + j + RESET);
                        i++;
                    }
                }
            }
        }
    }

    public static void jokerTileAdd(ArrayList<String> tileList) {
        tileList.add(14,FONT_WHITE + "WJ" + RESET); //WhiteJoker
        tileList.add(14,FONT_RED + "RJ" + RESET); //RedJoker
    }


    public static void tileShuffle(ArrayList<String> tileList) {
        for(int i = 0 ; i<3; i++){
            Collections.shuffle(tileList);
        }
    }

    public static void tileDivide(ArrayList<String> tileList, ArrayList<String> playerOneTileList, ArrayList<String> playerTwoTileList, int playerNum){
        int tileListSize = stackSize(tileList);

        // 가져갈 카드가 없어서 게임이 끝나야 하는 경우
        if(tileListSize < 0) Rule.gameEnding(tileList, playerOneTileList, playerTwoTileList);

        // 가져갈 카드가 있는 경우
        else{
            // 플레이어 지정하기
            if(playerNum == 1){
                playerOneTileList.add(Stack.pop(tileList));
            }

            else {
                playerTwoTileList.add(Stack.pop(tileList));
            }
        }
    }
}