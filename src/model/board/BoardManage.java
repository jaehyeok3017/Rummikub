package model.board;

import model.player.Player;
import model.tile.Tile;
import model.tile.TileManage;

import java.util.ArrayList;
import java.util.LinkedList;

import static model.game.PlayChoice.*;

public class BoardManage {
    public static ArrayList<LinkedList<Tile>> onBoardTileList = new ArrayList<>(106);
    public static ArrayList<LinkedList<Tile>> turnCheckCompleteTileList = new ArrayList<>(106);

    public static LinkedList<Tile> temporaryTile = new LinkedList<Tile>();
    private final TileManage tileManage;
    private int registerSum = 0;

    public BoardManage(TileManage tileManage) {
        this.tileManage = tileManage;
    }

    public void turnChanged(Player player) {
        boolean result = turnCheck(player);

        if (result) {
            turnIsSucceed();
        } else {
            turnIsFailed(player);
        }
    }

    public boolean turnCheck(Player player) {
        for (LinkedList<Tile> tileLinkedList : onBoardTileList) {
            if (tileLinkedList.size() < 3 && player.registerCheck) {
                return false;
            }
        }

        // 등록이 되지 않은 경우에 모든 숫자를 가져와서 더해줌
        if(!player.registerCheck){
            for (LinkedList<Tile> tiles : turnCheckCompleteTileList) {
                for (Tile tile : tiles) {
                    registerSum += tile.number;
                }
            }

            if(registerSum >= 30){
                player.registerCheck = true;
                System.out.println("카드의 총 합이 30을 넘어, 등록이 완료되었습니다!");
                return true;
            }

            else{
                System.out.println("기존에 등록이 진행되지 않았고, 낸 카드의 합이 30 미만입니다.");
                return false;
            }
        }

        return true;
    }

    public void turnIsFailed(Player player) {
        System.out.println("조건이 충족되지 않았으므로, 기존 배열로 돌아갑니다.");

        // 기존 배열을 제거
        onBoardTileList.removeAll(turnCheckCompleteTileList);

        // 플레이어에게 타일을 다시 추가
        for (LinkedList<Tile> tiles : turnCheckCompleteTileList) {
            player.tileList.addAll(tiles);
        }

        // 턴 체크하는 타일리스트 초기화 & 등록 체크하는 변수 초기화
        turnCheckCompleteTileList = new ArrayList<>(106);
        registerSum = 0;
    }

    public void turnIsSucceed() {
        // 턴 체크하는 타일리스트 초기화 & 등록 체크하는 변수 초기화
        turnCheckCompleteTileList = new ArrayList<>(106);
        registerSum = 0;
    }

    public void generateTemporaryTileList(Player player) {
        int result = 0;
        while (true) {
            tileManage.tileListPrint(player.tileList, player.name);
            System.out.print("\n\n현재 임시 배열 : ");
            tileManage.tileLinkPrint(temporaryTile);
            result = tileIndexPick(player);
            if (result == -1) break;

            if (result < -1 || result >= player.tileList.size()) {
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력하세요");
            }

            else{
                temporaryTile.add(player.tileList.get(result));
                player.tileList.remove(result);
            }
        }

        boolean isTemporaryComplete = generateTempCheck(player);
        if(isTemporaryComplete){
            turnCheckCompleteTileList.add(temporaryTile);
            onBoardTileList.add(temporaryTile);
        }
        else{
            player.tileList.addAll(temporaryTile);
        }
        temporaryTile = new LinkedList<Tile>();
    }

    public Boolean generateTempCheck(Player player) {
        int size = temporaryTile.size();

        if (size < 3) {
            System.out.println("임시 배열의 카드가 3개 미만입니다. 등록에 실패하였습니다.");
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

            if (temporaryTile.get(i).number == 999 || temporaryTile.get(i+1).number == 999) {
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

        else {
            System.out.println("색깔이나 숫자가 연속되지 않았습니다. 등록에 실패하였습니다.");
            return false;
        }
    }

    public void editOnBoardTileList(Player player) {
        int result = 0;
        while(true){
            int edit = editCheck();
            if(edit == -1) break;

            tileManage.tileLinkListPrint(onBoardTileList);
            int index = onBoardTileIndexPick();
            if(index > onBoardTileList.size() - 1) {
                System.out.println("인덱스의 범위가 잘못되었습니다.");
                continue;
            }

            tileManage.tileLinkPrint(onBoardTileList.get(index));
            int detailIndex = detailIndexPick(index);
            if(detailIndex > onBoardTileList.get(index).size() - 1){
                System.out.println("인덱스의 범위가 잘못되었습니다.");
                continue;
            }

            int work = workPick();
            tileManage.tileListPrint(player.tileList, player.name);
            result = tileIndexPick(player);
            if (result == -1) break;

            if (result < -1 || result >= player.tileList.size()) {
                System.out.println("잘못된 값을 입력하였습니다. 다시 입력하세요");
            }

            else{
                if(work == 1){
                    onBoardTileList.get(index).add(detailIndex, player.tileList.get(result));
                    player.tileList.remove(result);
                }

                else if(work == 2){
                    onBoardTileList.get(index).add(detailIndex + 1, player.tileList.get(result));
                    player.tileList.remove(result);
                }
            }
        }
    }

    public void moveOnBoardTile(Player player, int elementIndex) {

    }

    public void splitOnBoardTileList(Player player, int splitIndex) {

    }

    public int getOnBoardTileListSize() {
        return onBoardTileList.size();
    }
}