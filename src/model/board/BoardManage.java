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
    public static ArrayList<LinkedList<Tile>> previousTileList = new ArrayList<>(106);
    public static ArrayList<LinkedList<Tile>> playerPutTileList = new ArrayList<>(106);

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
        if (!player.registerCheck) {
            for (LinkedList<Tile> tiles : turnCheckCompleteTileList) {
                for (Tile tile : tiles) {
                    registerSum += tile.number;
                }
            }

            if (registerSum >= 30) {
                player.registerCheck = true;
                System.out.println("카드의 총 합이 30을 넘어, 등록이 완료되었습니다!");
                return true;
            } else {
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

        // 온보드에 다시 타일을 돌려놓기
        onBoardTileList.addAll(previousTileList);

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

        // onBoard 내용을 가져옴
        previousTileList = new ArrayList<>(106);
        previousTileList.addAll(onBoardTileList);
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
            } else {
                temporaryTile.add(player.tileList.get(result));
                player.tileList.remove(result);
            }
        }

        boolean isTemporaryComplete = generateTempCheck(player);
        if (isTemporaryComplete) {
            turnCheckCompleteTileList.add(temporaryTile);
            onBoardTileList.add(temporaryTile);
        } else {
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
            if ((temporaryTile.get(i).number == temporaryTile.get(i + 1).number - 1) && (temporaryTile.get(i).color == temporaryTile.get(i + 1).color)) {
                colorStack += 1;
            }

            if ((temporaryTile.get(i).number == temporaryTile.get(i + 1).number) && (temporaryTile.get(i).color != temporaryTile.get(i + 1).color)) {
                numberStack += 1;
            }

            if (temporaryTile.get(i).number == 999 || temporaryTile.get(i + 1).number == 999) {
                colorStack += 1;
                numberStack += 1;
            }
        }

        if (size - 1 == colorStack) {
            return true;
        } else if (size - 1 == numberStack) {
            return true;
        } else {
            System.out.println("색깔이나 숫자가 연속되지 않았습니다. 등록에 실패하였습니다.");
            return false;
        }
    }

    public void editOnBoardTileList(Player player) {
        int result = 0;
        while (true) {
            int edit = editCheck();
            if (edit == -1) break;

            tileManage.tileLinkListPrint(onBoardTileList);
            int index = onBoardTileIndexPick();
            if (index > onBoardTileList.size() - 1) {
                System.out.println("인덱스의 범위가 잘못되었습니다.");
                continue;
            }

            tileManage.tileLinkPrint(onBoardTileList.get(index));
            int detailIndex = detailIndexPick(index);
            if (detailIndex > onBoardTileList.get(index).size() - 1) {
                System.out.println("인덱스의 범위가 잘못되었습니다.");
                continue;
            }

            if (edit == 1) {
                tileManage.tileListPrint(player.tileList, player.name);
                result = tileIndexPick(player);
                if (result == -1) break;

                if (result < -1 || result >= player.tileList.size()) {
                    System.out.println("잘못된 값을 입력하였습니다. 다시 입력하세요");
                }
                int work = workPick();

                if (work == 1) {
                    boolean workCheck = false;
                    workCheck = workChecking(index, detailIndex, result, player);

                    if (workCheck) {
                        onBoardTileList.get(index).add(detailIndex, player.tileList.get(result));
                        player.tileList.remove(result);
                    }
                } else if (work == 2) {
                    boolean workCheck = false;
                    workCheck = workChecking(index, detailIndex, result, player);

                    if (workCheck) {
                        onBoardTileList.get(index).add(detailIndex + 1, player.tileList.get(result));
                        player.tileList.remove(result);
                    }
                }
            } else if (edit == 2) {
                boolean moveCheck = false;
                moveCheck = moveCheck(index, detailIndex, player);
                if (moveCheck) moveOnBoardTile(player, index, detailIndex);
            } else if (edit == 3) {
                boolean splitCheck = false;
                splitCheck = splitCheck(index, detailIndex, player);
                if (splitCheck) splitOnBoardTileList(player, index, detailIndex);
            }
        }
    }

    private boolean workChecking(int index, int detailIndex, int result, Player player) {
        // 숫자가 같은 경우, 색깔이 달라야 함
        if ((onBoardTileList.get(index).get(detailIndex).number == player.tileList.get(result).number) &&
                (onBoardTileList.get(index).get(detailIndex).color != player.tileList.get(result).color)) {
            return true;
        }

        // 색깔이 같은 경우, 숫자가 달라야 함
        else if (((onBoardTileList.get(index).get(detailIndex).number == player.tileList.get(result).number + 1)
                || (onBoardTileList.get(index).get(detailIndex).number == player.tileList.get(result).number - 1))
                && (onBoardTileList.get(index).get(detailIndex).color == player.tileList.get(result).color)) {
            return true;
        } else if (player.tileList.get(result).number == 999) {
            return true;
        } else {
            System.out.println("해당 요소는 해당 위치에 들어갈 수 없습니다.");
            return false;
        }
    }

    private boolean moveCheck(int index, int detailIndex, Player player) {
        // 온보딩의 사이즈와 이동할 아이가 제대로 되어있는지 확인
        return true;
    }

    public void moveOnBoardTile(Player player, int index, int detailIndex) {

    }

    private boolean splitCheck(int index, int detailIndex, Player player) {
        // 온보딩의 사이즈가 3이 넘는 지 확인, 왼쪽 오른쪽 기준으로 3이 넘는지 확인
        if (onBoardTileList.get(index).size() > 3) {
            if(onBoardTileList.get(detailIndex - 3) != null && onBoardTileList.get(detailIndex + 3) != null){
                return true;
            }

            else {
                System.out.println("타일을 구분 시, 좌/우로 3개가 남지 않으므로 구분이 불가능합니다.");
                return false;
            }
        } else {
            System.out.println("타일이 3개 이하이므로, 타일 구분이 불가능합니다.");
            return false;
        }
    }

    public void splitOnBoardTileList(Player player, int index, int detailIndex) {
        LinkedList<Tile> temp = new LinkedList<Tile>();

        for(int i = detailIndex; i<onBoardTileList.size(); i++){
            temp.add(onBoardTileList.get(index).get(i));
        }

        onBoardTileList.add(temp);
        onBoardTileList.get(index).removeAll(temp);
    }

    public int getOnBoardTileListSize() {
        return onBoardTileList.size();
    }
}