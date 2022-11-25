package model.board;

import model.player.Player;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    static ArrayList<LinkedList<Integer>> onBoardTileList = new ArrayList<>(106);
    static ArrayList<LinkedList<Integer>> previousOnBoardTileList = new ArrayList<>(106);

    static LinkedList<Integer> temporaryTile;

    public static void turnChanged() {
        Boolean result = turnCheck();
        if(result){
            turnIsSuccessed();
        }

        else{
            turnIsFailed();
        }
    }

    public static Boolean turnCheck() {
        for (LinkedList<Integer> integers : onBoardTileList) {
            int elementSize = integers.size();

            if (elementSize < 3) {
                return false;
            }
        }

        return true;
    }

    public static void turnIsFailed() {
        onBoardTileList = previousOnBoardTileList;
    }

    public static void turnIsSuccessed() {
        onBoardTileList.add(temporaryTile);
        temporaryTile = null;
    }

    public static void generateTemporaryTileList(Player player, LinkedList<Integer> temporaryTile) {

    }

    public static void editTemporaryTileList(Player player, LinkedList<Integer> temporaryTile) {

    }

    public static void generateOnBoardTileList(Player player, LinkedList<Integer> temporaryTile,
                                               ArrayList<LinkedList<Integer>> onBoardTileList){

    }

    public static void editOnBoardTileList(Player player, ArrayList<LinkedList<Integer>> onBoardTileList) {

    }

    public static void moveOnBoardTile(Player player, ArrayList<LinkedList<Integer>> onBoardTileList, int elementIndex) {

    }

    public static void splitOnBoardTileList(Player player, ArrayList<LinkedList<Integer>> onBoardTileList, int splitIndex) {

    }

    public static ArrayList<LinkedList<Integer>> getOnBoardTileList() {
        return onBoardTileList;
    }

    public static int getOnBoardTileListSize(ArrayList<LinkedList<Integer>> onBoardTileList) {
        return onBoardTileList.size();
    }
}
