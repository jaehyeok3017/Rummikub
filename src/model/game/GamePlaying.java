package model.game;

import model.board.BoardManage;
import model.player.Player;
import model.tile.Tile;
import model.tile.TileColor;
import model.tile.TileColor.*;
import model.tile.TileManage;

import java.util.*;

import static model.board.BoardManage.onBoardTileList;
import static model.board.BoardManage.temporaryTile;
import static model.game.GameInitAndEndSet.gameEnd;
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

        int result = gameEndCheck(noPickTileList, player1.tileList, player2.tileList);
        if(result != 0){
            if(result == 1) gameEnd(1);
            else if(result == 2) gameEnd(2);
            else if(result == 3) gameEnd(3);
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
        boolean turncheck = false;

        if (playerTurn == 1) {
            playerList = player1.tileList;
            playerName = player1.name;
            player = player1;
        } else {
            playerList = player2.tileList;
            playerName = player2.name;
            player = player2;
        }
        tileListManage.tileSortToNumber(playerList); //??? ????????? ?????? ??????

        for (int i = 0; i < playerList.size() - 3; i++) {
            // ????????? ?????? ????????? ?????? ??? ?????? 3??? ?????? ex) ??????11, ??????11, ??????11
            if (playerList.get(i).number == playerList.get(i + 1).number - 1 && playerList.get(i + 1).number - 1 == playerList.get(i + 2).number - 2) {
                if (playerList.get(i).color == playerList.get(i + 1).color && playerList.get(i + 1).color == playerList.get(i + 2).color && playerList.get(i).color == playerList.get(i + 2).color) {
                    //?????? ??????
                    for(int j = 0; j<3; j++){
                        temporaryTile.add(playerList.get(i));
                        playerList.remove(i);
                    }

                    onBoardTileList.add(temporaryTile);
                    temporaryTile = new LinkedList<Tile>();
                    turncheck = true;
                }
            }

            //????????? ?????? ?????? 3?????? ???????????? ???????????? ??????
            if (playerList.get(i).number == playerList.get(i + 1).number && playerList.get(i + 1).number == playerList.get(i + 2).number) {
                if (playerList.get(i).color != playerList.get(i + 1).color && playerList.get(i + 1).color != playerList.get(i + 2).color && playerList.get(i).color != playerList.get(i + 2).color) {
                    //?????? ??????
                    for(int j = 0; j<3; j++){
                        temporaryTile.add(playerList.get(i));
                        playerList.remove(i);
                    }

                    onBoardTileList.add(temporaryTile);
                    temporaryTile = new LinkedList<Tile>();
                    turncheck = true;
                }
            }
        }
//
//        for(int i = 0; i<onBoardTileList.size(); i++){
//            for(int j = 0; j<onBoardTileList.get(i).size(); j++){
//                for(int k = 0; k < player.tileList.size(); k++){
//                    if((onBoardTileList.get(i).get(0).number == playerList.get(k).number) && (onBoardTileList.get(i).get(1).number == playerList.get(k).number)
//                        && (onBoardTileList.get(i).get(0).color != playerList.get(k).color) && (onBoardTileList.get(i).get(1).color != playerList.get(k).color)){
//                        onBoardTileList.get(i).add(0, playerList.get(k));
//                        playerList.remove(k);
//                    }
//
//                    if((onBoardTileList.get(i).get(0).number != playerList.get(k).number) && (onBoardTileList.get(i).get(1).number != playerList.get(k).number)
//                            && (onBoardTileList.get(i).get(0).color == playerList.get(k).color) && (onBoardTileList.get(i).get(1).color == playerList.get(k).color)){
//                        onBoardTileList.get(i).add(0, playerList.get(k));
//                        playerList.remove(k);
//                    }
//
//                    int size = onBoardTileList.get(i).size();
//                    if((onBoardTileList.get(i).get(size - 1).number == playerList.get(k).number) && (onBoardTileList.get(i).get(size - 2).number == playerList.get(k).number)
//                            && (onBoardTileList.get(i).get(size - 1).color != playerList.get(k).color) && (onBoardTileList.get(i).get(size - 2).color != playerList.get(k).color)){
//                        onBoardTileList.get(i).add(onBoardTileList.get(i).size() - 1, playerList.get(k));
//                        playerList.remove(k);
//                    }
//
//                    if((onBoardTileList.get(i).get(0).number != playerList.get(size - 1).number) && (onBoardTileList.get(i).get(size - 2).number != playerList.get(k).number)
//                            && (onBoardTileList.get(i).get(size - 1).color == playerList.get(k).color) && (onBoardTileList.get(i).get(size - 2).color == playerList.get(k).color)){
//                        onBoardTileList.get(i).add(onBoardTileList.get(i).size() - 1, playerList.get(k));
//                        playerList.remove(k);
//                    }
//                }
//            }
//        }

        if (!turncheck) {
            //?????? ????????????
            if (tileListManage.isTileListNull(noPickTileList)) {
            } else {
                Tile tile = tileListManage.noPickTileDivide(playerList);
                System.out.print(playerName + "?????? [");
                tileListManage.tilePrint(tile);
                System.out.println("] ????????? ?????????????????????.");
            }
        }

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

        // ?????? ???????????? (p)
        if (Objects.equals(playChoice, "p") || Objects.equals(playChoice, "P")) {
            if (tileListManage.isTileListNull(noPickTileList)) {
            } else {
                Tile tile = tileListManage.noPickTileDivide(playerList);
                System.out.print(playerName + "?????? [");
                tileListManage.tilePrint(tile);
                System.out.println("] ????????? ?????????????????????.");
            }

            return true;
        }

        // ?????? ???????????? ?????? (n)
        else if (Objects.equals(playChoice, "n") || Objects.equals(playChoice, "N")) {
            tileListManage.tileSortToNumber(playerList);
            return false;
        }

        // ?????? ?????? (s)
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
            System.out.println("????????? ??????????????????. ?????? ???????????????.");
            pickOrShow();
            return false;
        }
    }
}