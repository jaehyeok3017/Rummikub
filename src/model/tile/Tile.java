package model.tile;

public class Tile {
    final static int WIDTH = 120; //카드 가로
    final static int HEIGHT = 180; //카드 세로

    Boolean isJoker = false;
    Boolean isBatched = false;


    //ArrayList<Integer> card = new ArrayList<Integer>();

    public Boolean jokerCheck(){
        return isJoker;
    }

    public Boolean batchCheck(){
        return isBatched;
    }
}