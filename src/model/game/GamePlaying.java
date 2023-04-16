package model.game;

import model.board.BoardManage;
import model.player.Player;
import model.tile.Tile;
import model.tile.TileManage;
import java.util.*;

import static model.board.BoardManage.onBoardTileList;
import static model.board.BoardManage.temporaryTile;
import static model.game.GameInitAndEndSet.gameEnd;
import static model.game.GameInitAndEndSet.gameEndCheck;
import static model.game.PlayChoice.*;
import static model.tile.TileManage.noPickTileList;

public record GamePlaying(BoardManage boardManage, TileManage tileListManage,
                          Player player1, Player player2) {
    private static int playerTurn = 1;

    public void gamePlay() {
        while (gameEndCheck(noPickTileList, player1.tileList, player2.tileList) == 0) {
            gamePlayToTurn();
        }

        int result = gameEndCheck(noPickTileList, player1.tileList, player2.tileList);
        if (result != 0) {
            if (result == 1) gameEnd(1);
            else if (result == 2) gameEnd(2);
            else if (result == 3) gameEnd(3);
        }
    }

    private void gamePlayToTurn() {
        boolean turnComplete = false;
        String playChoice = "1";

        do {
            tileListManage.tileLinkListPrint(onBoardTileList);
            if (playerTurn == 1) {
                tileListManage.tileListPrint(player1.tileList, player1.name);

                if (Objects.equals(player1.name, "ai") || Objects.equals(player1.name, "AI")) {
                    turnComplete = aiChoice();
                } else {
                    playChoice = pickOrShow();
                    turnComplete = choiceCheck(playChoice);
                }
            } else {
                tileListManage.tileListPrint(player2.tileList, player2.name);

                if (Objects.equals(player2.name, "ai") || Objects.equals(player2.name, "AI")) {
                    turnComplete = aiChoice();
                } else {
                    playChoice = pickOrShow();
                    turnComplete = choiceCheck(playChoice);
                }
            }
        } while (!turnComplete);

        if ((Objects.equals(playChoice, "p")) || (Objects.equals(playChoice, "P"))) {
            if (playerTurn == 1) playerTurn = 2;
            else playerTurn = 1;
        } else {
            if (playerTurn == 1) {
                boardManage.turnChanged(player1);
                playerTurn = 2;
            } else {
                boardManage.turnChanged(player2);
                playerTurn = 1;
            }
        }
    }

    private boolean aiChoice() {
        ArrayList<Tile> playerList = null;
        String playerName = null;
        boolean isTurnComplete = false;

        if (playerTurn == 1) {
            playerList = player1.tileList;
            playerName = player1.name;
        } else {
            playerList = player2.tileList;
            playerName = player2.name;
        }
        tileListManage.tileSortToNumber(playerList);

        for (int i = 0; i < playerList.size() - 3; i++) {
            // 숫자가 같고 색깔이 다를 때 타일 3개 내기 ex) 파랑11, 노랑11, 주황11
            if (isSameNumber(playerList, i)) {
                cardInsert(playerList, i);
                isTurnComplete = true;
            }

            //색깔이 같고 타일 3개가 연속적인 숫자라면 내기
            if (isConstantNumber(playerList, i)) {
                cardInsert(playerList, i);
                isTurnComplete = true;
            }
        }

        if (!isTurnComplete) {
            if (tileListManage.isTileListNull(noPickTileList)) {
            } else {
                Tile tile = tileListManage.noPickTileDivide(playerList);
                System.out.print(playerName + "에게 [");
                tileListManage.tilePrint(tile);
                System.out.println("] 카드가 추가되었습니다.");
            }
        }

        return true;
    }

    private Boolean isConstantNumber(ArrayList<Tile> playerList, int i){
        return (playerList.get(i).number == playerList.get(i + 1).number &&
                    playerList.get(i + 1).number == playerList.get(i + 2).number) &&

                (playerList.get(i).color != playerList.get(i + 1).color &&
                        playerList.get(i + 1).color != playerList.get(i + 2).color
                        && playerList.get(i).color != playerList.get(i + 2).color);
    }

    private Boolean isSameNumber(ArrayList<Tile> playerList, int i){
        return (playerList.get(i).number == playerList.get(i + 1).number - 1 &&
                playerList.get(i + 1).number - 1 == playerList.get(i + 2).number - 2) &&

                (playerList.get(i).color == playerList.get(i + 1).color &&
                playerList.get(i + 1).color == playerList.get(i + 2).color &&
                playerList.get(i).color == playerList.get(i + 2).color);
    }

    private void cardInsert(ArrayList<Tile> playerList, int i){
        for (int j = 0; j < 3; j++) {
            temporaryTile.add(playerList.get(i));
            playerList.remove(i);
        }

        onBoardTileList.add(temporaryTile);
        temporaryTile = new LinkedList<Tile>();
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
            if (tileListManage.isTileListNull(noPickTileList)) {
            } else {
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
            if (!player.isRegisterCheck) {
                boardManage.generateTemporaryTileList(player);
            } else {
                String choiceAddOrEdit = cardListAddOrEdit();
                if (Objects.equals(choiceAddOrEdit, "a") || Objects.equals(choiceAddOrEdit, "A")) {
                    boardManage.generateTemporaryTileList(player);
                } else if (Objects.equals(choiceAddOrEdit, "e") || Objects.equals(choiceAddOrEdit, "E")) {
                    boardManage.editOnBoardTileList(player);
                }
            }

            return false;
        } else if (Objects.equals(playChoice, "e") || Objects.equals(playChoice, "E")) {
            return true;
        } else {
            System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            pickOrShow();
            return false;
        }
    }
}