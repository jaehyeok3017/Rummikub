package model.player;

import model.tile.Tile;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class AI extends Player{
    public AI(String inputPlayerName) {
        super("AI");
    }


    //만약, 낼 타일이 없어서 타일을 가져올 경우 다시 한번 정렬시키키
    //타일 정렬 성공했으면 타일이 1 2 3 순서대로 되어있는지 확인
    //연결리스트 활용 첫번째 인덱스 뒤 다음 2개 숫자가 이어지는 숫자라면 내기, 이어지는 숫자가 없다면 p(가져오기)
    LinkedList<Tile> tileList = new LinkedList<Tile>();
}
