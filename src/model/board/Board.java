package model.board;

import java.util.ArrayList;

import model.board.LinkedList.*;
import model.player.Player;

public class Board {
    static ArrayList<Node> onBoardTileList = new ArrayList<>(106);
    static ArrayList<Node> previousOnBoardTileList = new ArrayList<>(106);
    static ArrayList<Node> temporaryTileList = new ArrayList<>(106);

    static Node onBoardTile = new Node();
    static Node temporaryTile = new Node();

    public static void turnChanged(ArrayList<Node> previousOnBoardTileList,
                                   ArrayList<Node> onBoardTileList, Player player){

    }

    public static void generateTemporaryTileList(Player player, ArrayList<Node> temporaryTileList,
                                                 int boardTileListSize) {

    }

    public static void editTemporaryTileList(Player player, ArrayList<Node> temporaryTileList,
                                             int boardTileListSize) {

    }

    public static void editOnBoardTileList(Player player, ArrayList<Node> onBoardTileList,
                                           int boardTileListSize){

    }

    public static void moveElement(Player player, ArrayList<Node> onBoardTileList, int elementIndex) {

    }

    public static void splitOnBoardTileList(Player player, ArrayList<Node> onBoardTileList, int splitIndex) {

    }

    public static ArrayList<Node> getOnBoardTileList() {
        return onBoardTileList;
    }

    public static int getOnBoardTileListSize(ArrayList<Node> boardTileList) {
        return boardTileList.size();
    }
}
