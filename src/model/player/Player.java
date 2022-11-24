package model.player;

import java.util.ArrayList;

public class Player {
    public String name;
    public int cardCount;
    public boolean registerCheck;
    public ArrayList<String> tileList = new ArrayList<String>(106);

    public Player(String inputPlayerName) {
        name = inputPlayerName;
        cardCount = 0;
        registerCheck = false;
    }
}
