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
}
