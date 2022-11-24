package model.tile;

import java.util.ArrayList;
import java.util.Collections;

import static model.game.GameInitAndEndSet.gameEnd;
import static model.tile.Stack.stackSize;

public class Tile {
    public int tileNum;
    public TileColor color;
    static ArrayList<String> noPickTileList = new ArrayList<>(106);
    static ArrayList<String> onBoardTileList = new ArrayList<>(106);

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

    public static void onBoardTileListShow() {
        for (String s : onBoardTileList) {
            System.out.println("[ " + s + " ]");
        }
    }

    public static void tileShuffle(ArrayList<String> tileList) {
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(tileList);
        }
    }

    public static void tileDivide(ArrayList<String> tileList, ArrayList<String> playerTileList) {
        int tileListSize = stackSize(tileList);

        // 가져갈 카드가 없어서 게임이 끝나야 하는 경우
        if (tileListSize < 0) gameEnd(0);

        // 가져갈 카드가 있는 경우
        else {
            playerTileList.add(Stack.pop(tileList));

            int playerTileListSize = stackSize(playerTileList);
            System.out.println("[" + playerTileList.get(playerTileListSize - 1) + "] 카드가 추가되었습니다.");
        }
    }

    public static ArrayList<String> getNoPickTileList() {
        return noPickTileList;
    }

    public static ArrayList<String> getOnBoardTileList() {
        return onBoardTileList;
    }
}