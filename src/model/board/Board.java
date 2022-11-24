package model.board;

import java.util.ArrayList;
import model.board.LinkedList.*;
import model.player.Player;

import static model.board.LinkedList.printList;

public class Board {
    static ArrayList<Node> onBoardTileList = new ArrayList<>(106);
    static Node onBoardTile = new Node();
    static Node temporaryTileList = new Node();

    public static void newTileListGenerate(Player player, Node boardTileList) {

    }

    public static void getOnBoardTileList() {
        printList();
    }
}
