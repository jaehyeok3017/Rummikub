package model.game;

import model.tile.Tile;
import model.tile.TileManage;

import java.util.*;

import static model.tile.TileManage.noPickTileList;

public class GameInitAndEndSet {
    public static void gameInitSetting(TileManage tileManage,
                                       ArrayList<Tile> playerOneTileList, ArrayList<Tile> playerTwoTileList) {
        tileManage.push(); // 타일 색깔을 매치시키고, ArrayList에 추가
        tileManage.tileShuffle(noPickTileList); // 타일을 셔플함

        // 플레이어에게 14개씩 카드를 할당
        for (int i = 0; i < 14; i++) {
            tileManage.noPickTileDivide(playerOneTileList);
            tileManage.noPickTileDivide(playerTwoTileList);
        }
    }

    public static int gameEndCheck(ArrayList<Tile> tileList, ArrayList<Tile> playerOneTileList, ArrayList<Tile> playerTwoTileList) {
        int tileListSize = TileManage.getStackSize(tileList);
        int playerOneListSize = TileManage.getStackSize(playerOneTileList);
        int playerTwoListSize = TileManage.getStackSize(playerTwoTileList);

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
            System.out.println("플레이어 1이 이겼습니다. 게임이 종료되었습니다.");
        }

        // 플레이어2 승리
        else if(gameEndStatus == 2){
            System.out.println("플레이어 2가 이겼습니다. 게임이 종료되었습니다.");
        }

        // 카드가 전체 빠져서 무승부
        else if (gameEndStatus == 3){
            System.out.println("카드 전체가 빠져서 무승부 처리되었습니다.");
        }
    }
}