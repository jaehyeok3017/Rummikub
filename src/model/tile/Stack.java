package model.tile;

import java.util.ArrayList;

import static model.tile.ColorCode.*;
import static model.tile.ColorCode.RESET;

public class Stack {
    public static void push(ArrayList<String> tileList){
        int i = 0;
        for(int r = 0; r<2; r++){
            for(TileColor tile : TileColor.values()){
                if(tile == TileColor.RED){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_RED + "R" + j + RESET);
                        i++;
                    }
                }

                if(tile == TileColor.YELLOW){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_YELLOW + "Y" + j + RESET);
                        i++;
                    }
                }

                if(tile == TileColor.BLUE){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_BLUE + "B" + j + RESET);
                        i++;
                    }
                }

                if(tile == TileColor.WHITE){
                    for(int j = 1; j < 14; j++){
                        tileList.add(i, FONT_WHITE + "W" + j + RESET);
                        i++;
                    }
                }
            }
        }

    }

    public static String pop(ArrayList<String> tileList){
        int listSize = stackSize(tileList);
        String popElement = tileList.get(listSize - 1);
        tileList.remove(listSize - 1);

        return popElement;
    }

    public static int stackSize(ArrayList<String> list) {
        return list.size();
    }
}
