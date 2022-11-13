package model.player;

import model.tile.Tile;

public class Player {
    public String name;
    public int cardCount;
    public String[] card = new String[54]; // 최대 카드 개수 106 & 최소 플레이 인원 2 == 54

    public Player(String inputPlayerName){
        name = inputPlayerName;
        cardCount = 0;
    }


}
