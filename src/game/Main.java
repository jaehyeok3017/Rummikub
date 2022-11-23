package game;

import model.player.Player;

import java.util.Scanner;

import static model.game.GameInitAndEndSet.gameInitSetting;
import static model.game.GamePlaying.gamePlay;
import static model.tile.Tile.getNoPickTileList;


public class Main {
    public static void main(String[] args) {

        // 01. 초기 게임 세팅
        Scanner scan = new Scanner(System.in);

        System.out.print("유저1의 이름을 입력하세요 : ");
        String playerOneNameInput = scan.next();
        Player playerOne = new Player(playerOneNameInput);

        System.out.print("유저2의 이름을 입력하세요 : ");
        String playerTwoNameInput = scan.next();
        Player playerTwo = new Player(playerTwoNameInput);

        gameInitSetting(getNoPickTileList(), playerOne.tileList, playerTwo.tileList, playerOne.name, playerTwo.name);

        // 02. 게임 시작 (여기 안에서 자체 루프 돌림)
        gamePlay(getNoPickTileList(), playerOne, playerTwo, playerOne.name, playerTwo.name);
    }
}
