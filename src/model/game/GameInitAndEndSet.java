package model.game;

import model.tile.Tile;
import model.tile.TileListManage;

import java.util.*;

import static model.tile.TileListManage.noPickTileList;

public class GameInitAndEndSet {
    private static Tile tile;

    public static void gameInitSetting(TileListManage tileManage,
                                       ArrayList<Tile> playerOneTileList, ArrayList<Tile> playerTwoTileList,
                                       String playerOneName, String playerTwoName) {
        tileManage.push(); // 타일 색깔을 매치시키고, ArrayList에 추가
        tileManage.tileShuffle(noPickTileList); // 타일을 셔플함

        // 플레이어에게 14개씩 카드를 할당
        for (int i = 0; i < 14; i++) {
            tileManage.noPickTileDivide(noPickTileList, playerOneTileList);
            tileManage.noPickTileDivide(noPickTileList, playerTwoTileList);
        }

        // 초기 배열을 보여줌 (테스트코드)
        // TODO : 테스트 종료 후 지우기 (위의 매개변수 playerOneName, playerTwoName 까지.)
        tileManage.tileListPrint(playerOneTileList, playerOneName);
        tileManage.tileListPrint(playerTwoTileList, playerTwoName);
        tileManage.tileListPrint(noPickTileList, "나머지");
    }

    public static int gameEndCheck(ArrayList<Tile> tileList, ArrayList<Tile> playerOneTileList, ArrayList<Tile> playerTwoTileList) {
        int tileListSize = TileListManage.getStackSize(tileList);
        int playerOneListSize = TileListManage.getStackSize(playerOneTileList);
        int playerTwoListSize = TileListManage.getStackSize(playerTwoTileList);

        // 유저1이 타일을 다 내서 게임을 끝내야 하는 경우
        if (playerOneListSize == 0) {
            return 1;
        }

        // 유저2가 타일을 다 내서 게임을 끝내야 하는 경우
        else if (playerTwoListSize == 0) {
            return 2;
        }

        // 타일 리스트에 더 이상 타일이 없어 게임을 끝내야 하는 경우, But. 플레이어들은 카드가 존재하는 경우
        // 위의 두 if문 으로 이미 플레이어 카드가 있는 지 판별이 끝났으므로, tileListSize만 검사함
        else if (tileListSize == 0) {
            return 3;
        }

        // 게임을 정상적으로 진행 해야 하는 경우
        else {
            return 0;
        }
    }

    public static void gameEnd(int gameEndStatus) {
        // 플레이어1 승리
        if(gameEndStatus == 1){

        }

        // 플레이어2 승리
        else if(gameEndStatus == 2){

        }

        // 카드가 전체 빠져서 무승부
        else if (gameEndStatus == 3){

        }
    }
}