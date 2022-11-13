package model.tile;

import java.util.ArrayList;
import java.util.Collections;

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
        for(tileColor tile : tileColor.values()){
            int i = 0;

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

    public static void jokerTileAdd(ArrayList<String> tileList) {
        tileList.add(14,FONT_WHITE + "WJ" + RESET); //WhiteJoker
        tileList.add(14,FONT_RED + "RJ" + RESET); //RedJoker
    }


    public static void tileShuffle(ArrayList<String> tileList) {
        for(int i = 0 ; i<3; i++){
            Collections.shuffle(tileList);
        }
    }
}