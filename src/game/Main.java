package game;

import model.player.Player;
import model.tile.Stack;

import java.util.ArrayList;
import java.util.Scanner;

import static model.tile.Tile.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> tileList = new ArrayList<>(106);

        // 초기 게임 세팅
        Stack.push(tileList); // 타일 색깔을 매치시키고, ArrayList에 추가
        jokerTileAdd(tileList); // 조커 타일을 추가시킴
        tileShuffle(tileList); // 타일을 셔플함

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

        Player.playerListShow(playerOne.tileList, playerOne.name);
        Player.playerListShow(playerTwo.tileList, playerTwo.name);

        System.out.println("\n-----------------\n 나머지 배열");
        tileListShow(tileList);
    }
}
