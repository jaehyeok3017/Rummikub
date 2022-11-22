package model.game;

import model.player.Player;
import model.tile.Stack;

import java.util.ArrayList;

import static model.tile.Stack.push;
import static model.tile.Tile.*;

public class GamePlay {
    public static void gameInitSetting(ArrayList<String> tileList,
                                       ArrayList<String> playerOneTileList, ArrayList<String> playerTwoTileList,
                                       String playerOneName, String playerTwoName){
        push(tileList); // 타일 색깔을 매치시키고, ArrayList에 추가
        jokerTileAdd(tileList); // 조커 타일을 추가시킴
        tileShuffle(tileList); // 타일을 셔플함

        // 플레이어에게 14개씩 카드를 할당
        for(int i = 0; i < 14; i++){
            tileDivide(tileList, playerOneTileList, playerTwoTileList, 1);
            tileDivide(tileList, playerOneTileList, playerTwoTileList, 2);
        }

        // 초기 배열을 보여줌 (테스트코드)
        // TODO : 테스트 종료 후 지우기 (위의 매개변수 playerOneName, playerTwoName 까지.)
        Player.playerListShow(playerOneTileList, playerOneName);
        Player.playerListShow(playerTwoTileList, playerTwoName);
        System.out.println("\n-----------------\n 나머지 배열");
        tileListShow(tileList);
    }

    public static void gamePlaying(ArrayList<String> tileList, ArrayList<String> playerOneTileList, ArrayList<String> playerTwoTileList){

    }

    public static int gameEndingCheck(ArrayList<String> tileList, ArrayList<String> playerOneTileList, ArrayList<String> playerTwoTileList) {
        int tileListSize = Stack.stackSize(tileList);
        int playerOneListSize = Stack.stackSize(playerOneTileList);
        int playerTwoListSize = Stack.stackSize(playerTwoTileList);

        // 유저1이 타일을 다 내서 게임을 끝내야 하는 경우
        if(playerOneListSize == 0){
            return 1;
        }

        // 유저2가 타일을 다 내서 게임을 끝내야 하는 경우
        else if(playerTwoListSize == 0){
            return 2;
        }

        // 타일 리스트에 더 이상 타일이 없어 게임을 끝내야 하는 경우, But. 플레이어들은 카드가 존재하는 경우
        // 위의 두 if문 으로 이미 플레이어 카드가 있는 지 판별이 끝났으므로, tileListSize만 검사함
        else if(tileListSize == 0){
            return 3;
        }

        // 게임을 정상적으로 진행 해야 하는 경우
        else {
            return 0;
        }
    }

    public static void gameEnd(int gameEndStatus){

    }
}
