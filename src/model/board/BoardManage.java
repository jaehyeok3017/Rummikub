package model.board;

import model.player.Player;
import model.tile.Tile;
import model.tile.TileManage;

import java.util.ArrayList;
import java.util.LinkedList;

import static model.game.PlayChoice.tileIndexPick;

public class BoardManage {
    public static ArrayList<LinkedList<Tile>> onBoardTileList = new ArrayList<>(106);
    static ArrayList<LinkedList<Tile>> preOnBoardTileList = new ArrayList<>(106);

    static LinkedList<Tile> temporaryTile = new LinkedList<Tile>();
    private final TileManage tileManage;

    public BoardManage(TileManage tileManage) {
        this.tileManage = tileManage;
    }

    public void turnChanged(Player player) {
        Boolean result = turnCheck(player);
        if (result) {
            turnIsSuccessed();
        } else {
            turnIsFailed(player);
        }
    }

    public boolean turnCheck(Player player) {
        for (int i = 0; i < onBoardTileList.size(); i++) {
            if (onBoardTileList.get(i).size() < 3 && player.registerCheck) {
                return false;
            }
        }

        return true;
    }

    public void turnIsFailed(Player player) {
        System.out.println("조건이 충족되지 않았으므로, 기존 배열로 돌아갑니다.");
        onBoardTileList.removeAll(preOnBoardTileList);
        onBoardTileList.addAll(preOnBoardTileList);
        player.tileList.addAll(temporaryTile);
        temporaryTile = new LinkedList<Tile>();
    }

    public void turnIsSuccessed() {
        onBoardTileList.add(temporaryTile);
        temporaryTile = new LinkedList<Tile>();
    }

    public void generateTemporaryTileList(Player player) {
        int result = 0;
        while (true) {
            tileManage.tileListPrint(player.tileList, player.name);
            System.out.print("\n\n현재 임시 배열 : ");
            tileManage.tileLinkPrint(temporaryTile);
            result = tileIndexPick(player);
            if (result == -1) break;

            if (result < -1 || result > player.tileList.size()) {
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력하세요");
                tileIndexPick(player);
            }

            temporaryTile.add(player.tileList.get(result));
            player.tileList.remove(result);
        }

        boolean check = generateTempCheck();
        if(check) turnIsSuccessed();
        else turnIsFailed(player);
    }

    public Boolean generateTempCheck() {
        int size = temporaryTile.size();

        if (size < 3) {
            System.out.println("임시 배열의 카드가 3개 미만입니다.");
            return false;
        }

        Boolean sameNumber = false;
        int numberStack = 0;

        Boolean sameColor = false;
        int colorStack = 0;

        for (int i = 0; i < size - 1; i++) {
            if ((temporaryTile.get(i).number == temporaryTile.get(i + 1).number - 1) && (temporaryTile.get(i).color == temporaryTile.get(i+1).color)) {
                colorStack += 1;
            }

            if ((temporaryTile.get(i).number == temporaryTile.get(i + 1).number) && (temporaryTile.get(i).color != temporaryTile.get(i+1).color)) {
                numberStack += 1;
            }

            if (temporaryTile.get(i).number == 999) {
                colorStack += 1;
                numberStack += 1;
            }
        }

        if (size - 1 == colorStack) {
            return true;
        }

        else if (size - 1 == numberStack) {
            return true;
        }

        else return false;
    }

    public void editTemporaryTileList(Player player) {

    }

    public void saveTemporaryTileList(Player player) {

    }

    public void generateOnBoardTileList(Player player) {

    }

    public void editOnBoardTileList(Player player) {

    }

    public void moveOnBoardTile(Player player, int elementIndex) {

    }

    public void splitOnBoardTileList(Player player, int splitIndex) {

    }

    public int getOnBoardTileListSize() {
        return onBoardTileList.size();
    }
}