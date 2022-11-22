package game;

import model.player.Player;
import java.util.ArrayList;
import java.util.Scanner;

import static model.tile.Tile.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> tileList = new ArrayList<>(106);

        // 초기 게임 세팅
        tileColorMatchAndAdd(tileList); // 타일 색깔을 매치시키고, ArrayList에 추가
        jokerTileAdd(tileList); // 조커 타일을 추가시킴
        tileShuffle(tileList); // 타일을 셔플함

        // 테스트용 코드
        for(int i = 0; i < 54; i++){
            System.out.println(tileList.get(i));
        }
        
        Scanner scan = new Scanner(System.in);

        System.out.print("유저1의 이름을 입력하세요 : ");
        String playerOneNameInput = scan.next();
        Player playerOne = new Player(playerOneNameInput);

        System.out.print("유저2의 이름을 입력하세요 : ");
        String playerTwoNameInput = scan.next();
        Player playerTwo = new Player(playerTwoNameInput);

        for(int i = 0; i < 14; i++){
            tileDivide(tileList, playerOne.tileList, playerTwo.tileList, 1);
            tileDivide(tileList, playerOne.tileList, playerTwo.tileList, 2);
        }

        System.out.println("-----------------\n 플레이어 " + playerOne.name + "의 배열");
        Player.playerListShow(playerOne.tileList);
        System.out.println("\n-----------------\n 플레이어 " + playerTwo.name + "의 배열");
        Player.playerListShow(playerTwo.tileList);
        System.out.println("\n-----------------\n 나머지 배열");
        tileListShow(tileList);
    }
}
