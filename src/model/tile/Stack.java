package model.tile;

import java.util.ArrayList;

public class Stack {
    public static void push(ArrayList<String> tileList){

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
