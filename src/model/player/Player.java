package model.player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Player {
    public String name;
    public int cardCount;
    public boolean registerCheck;
    public static boolean isFirstTileDivide;
    public static ArrayList<String> tileList = new ArrayList<String>(106);



    public Player(String inputPlayerName) {
        name = inputPlayerName;
        cardCount = 0; //TODO 추후구현
        registerCheck = false;
        isFirstTileDivide = true;
    }

    public static void playerTileListShow(ArrayList<String> list, String name) {
        System.out.println("\n-----------------\n" + name + " TileList");

        if (Objects.equals(name, "AI")) {
            System.out.println("응애 나 인공지능");
            Collections.sort(list);
        }



        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " : [" + list.get(i) + "], ");
            if (i % 7 == 0 && i != 0) System.out.println();
        }
    }
    }
