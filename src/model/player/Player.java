package model.player;

import model.tile.Stack;
import model.tile.Tile;

import java.util.ArrayList;

public class Player {
    public String name;
    public int cardCount;
    public ArrayList<String> tileList = new ArrayList<String>(52); // 최대 카드 개수 106 & 최소 플레이 인원 2 == 54

    public Player(String inputPlayerName) {
        name = inputPlayerName;
        cardCount = 0;
    }

    public static void playerListShow(ArrayList<String> list, String name){
        System.out.println("\n-----------------\n 플레이어 " + name + "의 배열");
        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
