package game;

import model.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static model.tile.Tile.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> tileList = new ArrayList<>(52);

        // 초기 게임 세팅
        tileColorMatchAndAdd(tileList); // 타일 색깔을 매치시키고, ArrayList에 추가
        jokerTileAdd(tileList); // 조커 타일을 추가시킴
        tileShuffle(tileList); // 타일을 셔플함


        // 테스트용 코드
        for(int i = 0; i < 54; i++){
            System.out.println(tileList.get(i));
        }
        
        Scanner scan = new Scanner(System.in);

        System.out.print("유저1의 이름을 입력하세요 : ");
        String player1 = scan.next();
        new Player(player1);

        System.out.print("유저2의 이름을 입력하세요 : ");
        String player2 = scan.next();
        new Player(player2);

        
    }
}
