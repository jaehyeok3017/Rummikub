package model.game;

import model.board.BoardManage;
import model.player.Player;
import model.tile.Tile;
import model.tile.TileColor;
import model.tile.TileColor.*;
import model.tile.TileManage;

import java.awt.desktop.AppReopenedEvent;
import java.util.*;

import static model.board.BoardManage.*;
import static model.game.GameInitAndEndSet.gameEndCheck;
import static model.game.PlayChoice.*;
import static model.tile.TileManage.noPickTileList;

public class GamePlaying {
    private static int playerTurn = 1;

    private final BoardManage boardManage;
    private final TileManage tileListManage;
    private final Player player1;
    private final Player player2;

    public GamePlaying(BoardManage boardManage, TileManage tileListManage, Player player1, Player player2) {
        this.boardManage = boardManage;
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
        Player player;
        boolean turnCheck = false;

        if (playerTurn == 1) {
            playerList = player1.tileList;
            playerName = player1.name;
            player = player1;
        } else {
            playerList = player2.tileList;
            playerName = player2.name;
            player = player2;
        }

//        if(!player.registerCheck) {
//            //TODO
//            int registerSum = 0;
//            for (LinkedList<Tile> tiles : turnCheckCompleteTileList) {
//                for (Tile tile : tiles) {
//                    registerSum = tile.number;
//                }
//            }
//
//            if (registerSum >= 30) {
//                player.registerCheck = true;
//                return true;
//            }
//        }
//
//        else{
            for (int i = 0; i < playerList.size() - 2; i++) {
                // 타일 색깔이 모두 같고, 숫자가 연속적일 경우
                if (playerList.get(i).number == playerList.get(i + 1).number - 1 && playerList.get(i + 1).number - 1 == playerList.get(i + 2).number - 2) {
                    if (playerList.get(i).color == playerList.get(i + 1).color && playerList.get(i + 1).color == playerList.get(i + 2).color && playerList.get(i).color == playerList.get(i + 2).color) {
                        //타일 내기
                        for(int j = 0; j<3; j++){
                            temporaryTile.add(playerList.get(i));
                            playerList.remove(i);
                        }

                        onBoardTileList.add(temporaryTile);
                        temporaryTile = new LinkedList<Tile>();
                        turnCheck = true;
                    }
                }

                //숫자가 같고, 색깔이 다를 경우
                if (playerList.get(i).number == playerList.get(i + 1).number && playerList.get(i + 1).number == playerList.get(i + 2).number) {
                    if (playerList.get(i).color != playerList.get(i + 1).color && playerList.get(i + 1).color != playerList.get(i + 2).color && playerList.get(i).color != playerList.get(i + 2).color) {
                        //타일 내기
                        for(int j = 0; j<3; j++){
                            temporaryTile.add(playerList.get(i));
                            playerList.remove(i);
                        }

                        onBoardTileList.add(temporaryTile);
                        temporaryTile = new LinkedList<Tile>();
                        turnCheck = true;
                    }
                }

                int onboardSize = onBoardTileList.size() - 1;
                //이미 올라가 있는 타일들에 타일 하나씩 추가하기 / 색깔이 같고3개 이상의 연속적인 값으로 이루어져있는 타일들 뒤에 타일 하나 붙이기
                if(onBoardTileList.get(onboardSize).get(-1).number == playerList.get(i).number + 1) {
                    if (onBoardTileList.get(onBoardTileList.size() - 1).get(-1).color == playerList.get(i).color) {
                        for (int j = 0; j < 2; j++) {
                            temporaryTile.addLast(playerList.get(i));
                            playerList.remove(i);
                        }

                        onBoardTileList.add(temporaryTile);
                        temporaryTile = new LinkedList<Tile>();
                        turnCheck = true;
                    }
                }

                //이미 올라가 있는 타일들에 타일 하나씩 추가하기 / 색깔이 다르고 같은 값으로 이루어져있는 타일들 뒤에 타일 하나 붙이기
                if(onBoardTileList.get(onBoardTileList.size() - 1).get(1).number == playerList.get(i).number) {
                    if (onBoardTileList.get(onBoardTileList.size() - 1).get(1).color != playerList.get(i).color) {
                        for (int j = 0; j < 2; j++) {
                            temporaryTile.addLast(playerList.get(i));
                            playerList.remove(i);
                        }

                        onBoardTileList.add(temporaryTile);
                        temporaryTile = new LinkedList<Tile>();
                        turnCheck = true;
                    }
                }
//            }
        }

        if (!turnCheck) {
            //타일 가져가기
            if (tileListManage.isTileListNull(noPickTileList)) {
            } else {
                Tile tile = tileListManage.noPickTileDivide(playerList);
                System.out.print(playerName + "에게 [");
                tileListManage.tilePrint(tile);
                System.out.println("] 카드가 추가되었습니다.");
            }
        }
        tileListManage.tileSortToNumber(playerList); //돌 때마다 정렬 해줌
        return true;
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

        // TODO
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
            if (!player.registerCheck) {
                boardManage.generateTemporaryTileList(player);
            } else {
                String choiceAddOrEdit = addOrEdit();
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