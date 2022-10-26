package model.card;

public class Card {
    int cardNumber;
    String color;
    Boolean isJoker = false;
    Boolean isBatched = false;

    public Boolean jokerCheck(){
        return isJoker;
    }

    public Boolean batchCheck(){
        return isBatched;
    }
}