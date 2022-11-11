package game;

import model.player.Player;
import model.tile.tileColor;

import java.util.Scanner;

import static model.tile.color.*;

public class Main {
    public static void main(String[] args) {
//        GameFrame frame = new GameFrame();

        for(tileColor tColor : tileColor.values()){
            if(tColor == tileColor.RED){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_RED + "R" + i + RESET);
                }
            }
            if(tColor == tileColor.YELLOW){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_YELLOW + "Y" + i + RESET);
                }
            }
            if(tColor == tileColor.BLUE){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_BLUE + "B" + i + RESET);
                }
            }
            if(tColor == tileColor.WHITE){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_WHITE + "W" + i + RESET);
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("유저의 이름을 입력하세요 : ");
        String name = scan.next();

        new Player(name);
    }
}
