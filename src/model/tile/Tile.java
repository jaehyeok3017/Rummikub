package model.tile;

import java.util.ArrayList;
import java.util.Collections;

import static model.game.GameInitAndEndSet.gameEnd;
import static model.tile.Stack.stackSize;
import static model.tile.ColorCode.*;
import static model.tile.ColorCode.RESET;

public class Tile {
    public int tileNum;
    public TileColor color;
    static ArrayList<String> noPickTileList = new ArrayList<>(106);

    public Tile(int tileNum, TileColor color){
        this.tileNum = tileNum;
        this.color = color;
    }

    public static void jokerTileAdd(ArrayList<String> tileList) {
        tileList.add(14,FONT_WHITE + "WJ" + RESET); //WhiteJoker
        tileList.add(14,FONT_RED + "RJ" + RESET); //RedJoker
    }

    public static void tileListShow(ArrayList<String> list, String name){
        System.out.println("\n-----------------\n 플레이어 " + name + "의 배열");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("\n-----------------");
    }

    public static void tileShuffle(ArrayList<String> tileList) {
        for(int i = 0 ; i<3; i++){
            Collections.shuffle(tileList);
        }
    }

    public static void tileDivide(ArrayList<String> tileList, ArrayList<String> playerTileList){
        int tileListSize = stackSize(tileList);

        // 가져갈 카드가 없어서 게임이 끝나야 하는 경우
        if(tileListSize < 0) gameEnd(0);

        // 가져갈 카드가 있는 경우
        else{
            playerTileList.add(Stack.pop(tileList));
        }
    }

    public static ArrayList<String> getNoPickTileList(){
        return noPickTileList;
    }
}