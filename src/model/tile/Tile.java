package model.tile;

public class Tile {
    final static int WIDTH = 120; //카드 가로
    final static int HEIGHT = 180; //카드 세로
    public int tileNum;
    public tileColor color;

    public Tile(int tileNum, tileColor color){
        this.tileNum = tileNum;
        this.color = color;
    }

    Boolean isJoker = false;
    Boolean isBatched = false;
    public Boolean jokerCheck(){
        return isJoker;
    }

    public Boolean batchCheck(){
        return isBatched;
    }
}