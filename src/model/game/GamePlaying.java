package model.game;

import model.board.BoardManage;
import model.player.Player;
import model.tile.Tile;
import model.tile.TileManage;

import java.util.*;

import static model.game.GameInitAndEndSet.gameEndCheck;
import static model.game.PlayChoice.*;
import static model.tile.TileManage.noPickTileList;

public class GamePlaying {
    private static int playerTurn = 1;

    private final TileManage tileListManage;
    private final Player player1;
    private final Player player2;

    public GamePlaying(TileManage tileListManage, Player player1, Player player2) {
        this.tileListManage = tileListManage;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void gamePlay() {
        while (gameEndCheck(noPickTileList, player1.tileList, player2.tileList) == 0) {
            gamePlayToTurn();
        }
    }

    private void gamePlayToTurn() {
        boolean turnComplete = false;

        do{
            if (playerTurn == 1) {
                tileListManage.tileListPrint(player1.tileList, player1.name);
            } else {
                tileListManage.tileListPrint(player2.tileList, player2.name);
            }
            String playChoice = pickOrShow();
            turnComplete = choiceCheck(playChoice);
        } while(!turnComplete);

        if (playerTurn == 1) {
            playerTurn = 2;
        } else {
            playerTurn = 1;
        }
    }

    private Boolean choiceCheck(String playChoice) {
        ArrayList<Tile> playerList = null;
        String playerName = null;
        Player player;

        if (playerTurn == 1) {
            playerList = player1.tileList;
            playerName = player1.name;
            player = player1;
        } else {
            playerList = player2.tileList;
            playerName = player2.name;
            player = player2;
        }

        // 카드 가져오기 (p)
        if (Objects.equals(playChoice, "p") || Objects.equals(playChoice, "P")) {
            if(tileListManage.isTileListNull(noPickTileList)){
            }

            else{
                Tile tile = tileListManage.noPickTileDivide(playerList);
                System.out.print(playerName + "에게 [");
                tileListManage.tilePrint(tile);
                System.out.println("] 카드가 추가되었습니다.");
            }

            return true;
        }

        // 숫자 기준으로 정렬 (n)
        else if (Objects.equals(playChoice, "n") || Objects.equals(playChoice, "N")) {
            tileListManage.tileSortToNumber(playerList);
            return false;
        }

        // 카드 내기 (s)
        else if (Objects.equals(playChoice, "s") || Objects.equals(playChoice, "S")) {
            if (!player.registerCheck) {
                int registerResult = 0;
                do{
                    registerResult = generateNoRegister();
                    BoardManage.generateTemporaryTileList(player);
                } while(registerResult != 3);
            } else {
                String choiceAddOrEdit = addOrEdit();
                if (Objects.equals(choiceAddOrEdit, "a") || Objects.equals(choiceAddOrEdit, "A")) {

                } else if (Objects.equals(choiceAddOrEdit, "e") || Objects.equals(choiceAddOrEdit, "E")) {

                }
            }

            return true;
        }

        else {
            System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            pickOrShow();
            return false;
        }
    }
}