package model.tile;

public class Tile {
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