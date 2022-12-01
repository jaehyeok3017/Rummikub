package model.game;

import model.board.BoardManage;
import model.player.Player;
import model.tile.Tile;
import model.tile.TileColor;
import model.tile.TileColor.*;
import model.tile.TileManage;

import java.util.*;

import static model.board.BoardManage.onBoardTileList;
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

                if(Objects.equals(player1.name, "ai") || Objects.equals(player1.name, "AI")){
                    turnComplete = aiChoice();
                } else {
                    playChoice = pickOrShow();
                    turnComplete = choiceCheck(playChoice);
                }
            } else {
                tileListManage.tileListPrint(player2.tileList, player2.name);

                if(Objects.equals(player2.name, "ai") || Objects.equals(player2.name, "AI")){
                    turnComplete = aiChoice();
                } else {
                    playChoice = pickOrShow();
                    turnComplete = choiceCheck(playChoice);
                }
            }
        } while (!turnComplete);

        if((Objects.equals(playChoice, "p")) || (Objects.equals(playChoice, "P"))){
            if(playerTurn == 1) playerTurn = 2;
            else playerTurn = 1;
        }

        else{
            if (playerTurn == 1) {
                boardManage.turnChanged(player1);
                playerTurn = 2;
            } else {
                boardManage.turnChanged(player2);
                playerTurn = 1;
            }
        }
    }

    private boolean aiChoice(){
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
        int size = playerList.size();


        // TODO AI가 할 행동 작성하기
        // 접근할 수 있는 방법들은 아래 choiceCheck Method를 참고해볼 것
        // 모르겠으면 질문

        //숫자가 같고 색깔이 다를 때 타일 3개 내기 ex) 파랑11, 노랑11, 주황11
        do {
            for (int i = 0; i < size; i++) {
                //숫자가 같은지 확인
                if (playerList.get(i).number == playerList.get(i + 1).number - 1 && playerList.get(i + 1).number - 1 == playerList.get(i + 2).number - 2) {
                    if(playerList.get(i).color != playerList.get(i + 1).color && playerList.get(i + 1).color != playerList.get(i + 2).color && playerList.get(i).color != playerList.get(i + 2).color){
                        //타일 내기

                    }

                }

                //색깔이 같고 타일 3개가 연속적인 숫자라면 내기
                else if(playerList.get(i).number + 1 == playerList.get(i + 1).number && playerList.get(i + 1).number + 1 == playerList.get(i + 2).number){
                    if(playerList.get(i).color == playerList.get(i + 1).color && playerList.get(i + 1).color == playerList.get(i + 2).color && playerList.get(i).color == playerList.get(i + 2).color){
                        //타일 내기
                    }
                }

                else{
                    //타일 가져가기
                }
            }
            tileListManage.tileSortToNumber(playerList); //돌 때마다 정렬 해줌
        }while (size > 3);

        // TileManage.java 접근하고 싶으면? : tileListManage.[메서드이름] 으로 접근 가능
        // BoardManage.java 접근하고 싶다면? : boardManage.[메서드이름] 으로 접근 가능
        // -> 플레이어 기준으로 작성되어 있는 게 많으므로, 걸러서 작성해야 해야됨

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

                }
            }

            return false;
        }

        else if (Objects.equals(playChoice, "e") || Objects.equals(playChoice, "E")) {
            return true;
        }

        else {
            System.out.println("잘못된 선택지입니다. 다시 입력하세요.");
            pickOrShow();
            return false;
        }
    }
}