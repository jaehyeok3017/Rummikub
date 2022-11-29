package model.game;

import model.player.Player;
import model.tile.Tile;
import model.tile.TileListManage;

import java.util.*;

import static model.board.BoardAndTurn.generateTemporaryTileList;
import static model.game.GameInitAndEndSet.gameEndCheck;
import static model.game.PlayChoice.*;
import static model.tile.TileListManage.noPickTileList;

public class GamePlaying {
    static int playerTurn = 1;

    public static void gamePlay(TileListManage tileListManage,
                                Player playerOne, Player playerTwo,
                                String playerOneName, String playerTwoName) {
        while (gameEndCheck(noPickTileList, playerOne.tileList, playerTwo.tileList) == 0) {
            gamePlayToTurn(tileListManage, playerOne, playerOneName, playerTwo, playerTwoName);
        }
    }

    private static void gamePlayToTurn(TileListManage tileManage,
                                       Player playerOne, String playerOneName,
                                       Player playerTwo, String playerTwoName) {
//        turnChanged();
        if (playerTurn == 1) {
            playerTurn = 2;
            tileManage.playerTileListShow(playerOne.tileList, playerOneName);
            String playChoice = playChoicePickOrShow();
            choiceCheck(tileManage, playChoice, playerOne.tileList, playerOneName, playerOne);
        } else if (playerTurn == 2) {
            playerTurn = 1;
            tileManage.playerTileListShow(playerTwo.tileList, playerTwoName);
            String playChoice = playChoicePickOrShow();
            choiceCheck(tileManage, playChoice, playerTwo.tileList, playerTwoName, playerTwo);
        }
    }

    private static void choiceCheck(TileListManage tileManage,
                                    String playChoice,
                                    ArrayList<Tile> playerList, String playerName,
                                    Player player) {
        // 카드 가져오기 (p)
        if (Objects.equals(playChoice, "p") || Objects.equals(playChoice, "P")) {
            String tile = tileManage.noPickTileDivide(noPickTileList, playerList);
            System.out.println(playerName + "에게 [" + tile + "] 카드가 추가되었습니다.");
        }

        // 카드 내기 (s)
        else if (Objects.equals(playChoice, "s") || Objects.equals(playChoice, "S")) {
            if (!player.registerCheck) {
                int registerResult = 0;
                do{
                    registerResult = playChoiceGenerateNoRegister();
                    generateTemporaryTileList(player);
                } while(registerResult != 3);
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
