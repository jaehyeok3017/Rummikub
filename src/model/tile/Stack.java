package model.tile;

import model.board.LinkedList;

import java.util.ArrayList;
import java.util.Collections;

import static model.tile.ColorCode.*;
import static model.tile.ColorCode.RESET;

public class Stack {
    public static void push(ArrayList<String> tileList){
        int i = 0;
        for(int r = 0; r<2; r++){
            for(TileColor tile : TileColor.values()){
                if(tile == TileColor.RED){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_RED + j + RESET);
                        i++;
                    }
                }

                if(tile == TileColor.YELLOW){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_YELLOW + j + RESET);
                        i++;
                    }
                }

                if(tile == TileColor.BLUE){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_BLUE + j + RESET);
                        i++;
                    }
                }

                if(tile == TileColor.WHITE){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_WHITE + j + RESET);
                        i++;
                    }
                }
            }
        }
        tileList.add(i++, FONT_WHITE + "JOKER" + RESET); //WhiteJoker
        tileList.add(i, FONT_RED + "JOKER" + RESET); //RedJoker
    }

    public static String pop(ArrayList<String> tileList){
        int listSize = getStackSize(tileList);
        String popElement = tileList.get(listSize - 1);
        tileList.remove(listSize - 1);

        return popElement;
    }

    public static int getStackSize(ArrayList<String> list) {
        return list.size();
    }
}