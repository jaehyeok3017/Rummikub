package model.game;

import model.player.Player;

import java.util.*;

import static model.game.GameInitAndEndSet.gameEndCheck;
import static model.tile.Tile.tileDivide;
import static model.tile.Tile.tileListShow;

public class GamePlaying {
    static Scanner scan = new Scanner(System.in);
    static int playerTurn = 1;

    public static void gamePlay(ArrayList<String> tileList, Player playerOne, Player playerTwo,
                                String playerOneName, String playerTwoName) {
        while(gameEndCheck(tileList, playerOne.tileList, playerTwo.tileList) == 0){
            if (playerTurn == 1) {
                playerTurn = 2;
                tileListShow(playerOne.tileList, playerOneName);
                String playChoice = playChoice();
                choiceCheck(playChoice, tileList, playerOne.tileList, playerOneName);
            }

            else if (playerTurn == 2) {
                playerTurn = 1;
                tileListShow(playerTwo.tileList, playerTwoName);
                String playChoice = playChoice();
                choiceCheck(playChoice, tileList, playerTwo.tileList, playerTwoName);
            }
        }
    }

    private static String playChoice() {
        System.out.print("\n카드 가져오기 : P or p / 카드 내기 : Q or q : ");
        return scan.next();
    }

    private static void choiceCheck(String playChoice, ArrayList<String> tileList,
                                    ArrayList<String> playerList, String playerName) {
        // 카드 가져오기 (p)
        if(Objects.equals(playChoice, "p") || Objects.equals(playChoice, "P")){
            tileDivide(tileList, playerList);
        }

        // 카드 내기 (q)
        else if(Objects.equals(playChoice, "q") || Objects.equals(playChoice, "Q")){
        }

        else{
            System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            playChoice();
        }
    }
}
