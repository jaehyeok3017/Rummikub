package model.tile;

import java.util.ArrayList;
import java.util.Collections;

import static model.game.GameInitAndEndSet.gameEnd;
import static model.tile.Stack.getStackSize;

public class Tile {
    public int tileNum;
    public TileColor color;
    static ArrayList<String> noPickTileList = new ArrayList<>(106);

    public Tile(int tileNum, TileColor color) {
        this.tileNum = tileNum;
        this.color = color;
    }

    public static void playerTileListShow(ArrayList<String> list, String name) {
        System.out.println("\n-----------------\n" + name + " TileList");
        for (String s : list) {
            System.out.print("[" + s + "], ");
        }
    }

    public static void tileShuffle(ArrayList<String> tileList) {
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(tileList);
        }
    }

    public static String noPickTileDivide(ArrayList<String> tileList, ArrayList<String> playerTileList) {
        int tileListSize = getStackSize(tileList);

        // 가져갈 카드가 없어서 게임이 끝나야 하는 경우
        if (tileListSize < 0) {
            gameEnd(0);
            return "None";
        }

        // 가져갈 카드가 있는 경우
        else {
            playerTileList.add(Stack.pop(tileList));

            int playerTileListSize = getStackSize(playerTileList);
            return playerTileList.get(playerTileListSize - 1);
        }
    }

    public static ArrayList<String> getNoPickTileList() {
        return noPickTileList;
    }
}