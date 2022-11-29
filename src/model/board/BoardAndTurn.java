package model.board;

import model.player.Player;
import model.tile.Tile;
import model.tile.TileListManage;

import java.util.ArrayList;
import java.util.LinkedList;

import static model.game.PlayChoice.playChoiceTileIndex;

public class BoardAndTurn {
    static ArrayList<LinkedList<Tile>> onBoardTileList = new ArrayList<>(106);
    static ArrayList<LinkedList<Tile>> previousOnBoardTileList = new ArrayList<>(106);

    static LinkedList<Tile> temporaryTile;

    public void turnChanged() {
        Boolean result = turnCheck();
        if (result) {
            turnIsSuccessed();
        } else {
            turnIsFailed();
        }
    }

    public Boolean turnCheck() {
        for (LinkedList<Tile> integers : onBoardTileList) {
            int elementSize = integers.size();

            if (elementSize < 3) {
                return false;
            }
        }

        return true;
    }

    public void turnIsFailed() {
        System.out.println("조건이 충족되지 않았으므로, 기존 배열로 돌아갑니다.");
        onBoardTileList.removeAll(previousOnBoardTileList);
        onBoardTileList.addAll(previousOnBoardTileList);
        temporaryTile = null;
    }

    public void turnIsSuccessed() {
        onBoardTileList.add(temporaryTile);
        temporaryTile = null;
    }

    public static void generateTemporaryTileList(Player player) {
        int result = 0;
        while (true) {
            result = playChoiceTileIndex(player);
            if (result == -1) break;

            if (result < -1 || result > player.tileList.size()){
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력하세요");
                playChoiceTileIndex(player);
            }

            temporaryTile.add(player.tileList.get(result));
        }
    }

    // TODO Boolean으로 자료형 변경
    public static void generateTempCheck(){
        int size = temporaryTile.size();

        if(size < 3){
            System.out.println("임시 배열의 카드가 3개 미만입니다.");
//            return false;
        }

        Boolean sameNumber = true;
        Boolean sameColor = true;

        for(int i = 0; i < temporaryTile.size() - 3; i++){

        }
    }

    public static void editTemporaryTileList(Player player, LinkedList<Integer> temporaryTile) {

    }

    public static void saveTemporaryTileList(Player player, LinkedList<Integer> temporaryTile) {

    }

    public static void generateOnBoardTileList(Player player, LinkedList<Integer> temporaryTile,
                                               ArrayList<LinkedList<Integer>> onBoardTileList) {

    }

    public static void editOnBoardTileList(Player player, ArrayList<LinkedList<Integer>> onBoardTileList) {

    }

    public static void moveOnBoardTile(Player player, ArrayList<LinkedList<Integer>> onBoardTileList, int elementIndex) {

    }

    public static void splitOnBoardTileList(Player player, ArrayList<LinkedList<Integer>> onBoardTileList, int splitIndex) {

    }

//    public static ArrayList<LinkedList<Integer>> getOnBoardTileList() {
//    }

    public static int getOnBoardTileListSize(ArrayList<LinkedList<Integer>> onBoardTileList) {
        return onBoardTileList.size();
    }
}
