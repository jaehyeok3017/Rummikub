package model.tile;

public class Tile {

    final static int WIDTH = 120; //카드 가로
    final static int HEIGHT = 180; //카드 세로
    String[] cardNumber = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"}; //타일 숫자:1 ~ 13
    String[] cardColor = {"Red", "Orange", "Blue", "Black"}; //카드 색깔 : 빨강, 주황, 파랑, 검정
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