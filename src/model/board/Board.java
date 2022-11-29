package model.board;

import model.tile.Tile;

import java.util.ArrayList;
import java.util.LinkedList;

public class Board {
    static ArrayList<LinkedList<Tile>> onBoardTileList = new ArrayList<>(106);
    static ArrayList<LinkedList<Tile>> preOnBoardTileList = new ArrayList<>(106);

    static LinkedList<Tile> temporaryTile;
}
