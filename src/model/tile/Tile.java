package model.tile;

import model.game.GamePlay;

import java.util.ArrayList;
import java.util.Collections;

import static model.tile.Stack.stackSize;
import static model.tile.Color.*;
import static model.tile.Color.RESET;

public class Tile {
    public int tileNum;
    public TileColor color;

    public Tile(int tileNum, TileColor color){
        this.tileNum = tileNum;
        this.color = color;
    }

    public static void jokerTileAdd(ArrayList<String> tileList) {
        tileList.add(14,FONT_WHITE + "WJ" + RESET); //WhiteJoker
        tileList.add(14,FONT_RED + "RJ" + RESET); //RedJoker
    }

    public static void tileListShow(ArrayList<String> tileList) {
        int tileListSize = stackSize(tileList);

        for(int i = 0; i<tileListSize; i++){
            System.out.print(tileList.get(i) + " ");
        }
    }

    public static void tileShuffle(ArrayList<String> tileList) {
        for(int i = 0 ; i<3; i++){
            Collections.shuffle(tileList);
        }
    }

    public static void tileDivide(ArrayList<String> tileList, ArrayList<String> playerOneTileList, ArrayList<String> playerTwoTileList, int playerNum){
        int tileListSize = stackSize(tileList);

        // 가져갈 카드가 없어서 게임이 끝나야 하는 경우
        if(tileListSize < 0) GamePlay.gameEndingCheck(tileList, playerOneTileList, playerTwoTileList);

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