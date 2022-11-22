package game;

import model.player.Player;
import model.tile.Stack;

import java.util.ArrayList;
import java.util.Scanner;

import static model.game.GamePlay.gameInitSetting;
import static model.tile.Tile.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> tileList = new ArrayList<>(106);

        // 01. 초기 게임 세팅
        Scanner scan = new Scanner(System.in);

        System.out.print("유저1의 이름을 입력하세요 : ");
        String playerOneNameInput = scan.next();
        Player playerOne = new Player(playerOneNameInput);

        System.out.print("유저2의 이름을 입력하세요 : ");
        String playerTwoNameInput = scan.next();
        Player playerTwo = new Player(playerTwoNameInput);

        gameInitSetting(tileList, playerOne.tileList, playerTwo.tileList, playerOne.name, playerTwo.name);
    }
}
