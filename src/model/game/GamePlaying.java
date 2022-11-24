package model.game;

import model.player.Player;

import java.util.*;

import static model.game.GameInitAndEndSet.gameEndCheck;
import static model.game.PlayChoice.*;
import static model.tile.Tile.*;

public class GamePlaying {
    static int playerTurn = 1;

    public static void gamePlay(ArrayList<String> tileList, Player playerOne, Player playerTwo,
                                String playerOneName, String playerTwoName) {
        while (gameEndCheck(tileList, playerOne.tileList, playerTwo.tileList) == 0) {
            gamePlayToTurn(tileList, playerOne, playerOneName, playerTwo, playerTwoName);
        }
    }

    private static void gamePlayToTurn(ArrayList<String> tileList, Player playerOne, String playerOneName,
                                       Player playerTwo, String playerTwoName) {
        if (playerTurn == 1) {
            playerTurn = 2;
            playerTileListShow(playerOne.tileList, playerOneName);
            String playChoice = playChoicePickOrShow();
            choiceCheck(playChoice, tileList, playerOne.tileList, playerOneName, playerOne);
        } else if (playerTurn == 2) {
            playerTurn = 1;
            playerTileListShow(playerTwo.tileList, playerTwoName);
            String playChoice = playChoicePickOrShow();
            choiceCheck(playChoice, tileList, playerTwo.tileList, playerTwoName, playerTwo);
        }
    }

    private static void choiceCheck(String playChoice, ArrayList<String> tileList,
                                    ArrayList<String> playerList, String playerName,
                                    Player player) {
        // 카드 가져오기 (p)
        if (Objects.equals(playChoice, "p") || Objects.equals(playChoice, "P")) {
            String tile = noPickTileDivide(tileList, playerList);
            System.out.println(playerName + "에게 [" + tile + "] 카드가 추가되었습니다.");
        }

        // 카드 내기 (s)
        else if (Objects.equals(playChoice, "s") || Objects.equals(playChoice, "S")) {
            if (!player.registerCheck) {

            } else {
                String choiceAddOrEdit = playChoiceAddOrEdit();
                if (Objects.equals(choiceAddOrEdit, "a") || Objects.equals(choiceAddOrEdit, "A")) {

                } else if (Objects.equals(choiceAddOrEdit, "e") || Objects.equals(choiceAddOrEdit, "E")) {

                }
            }
        } else {
            System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            playChoicePickOrShow();
        }
    }
}
