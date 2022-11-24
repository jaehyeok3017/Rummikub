package model.board;

import java.util.ArrayList;

public class Board {
    static ArrayList<String> onBoardTileList = new ArrayList<>(106);

    public static ArrayList<String> getOnBoardTileList() {
        return onBoardTileList;
    }
}
