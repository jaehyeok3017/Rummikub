package game;

import model.player.Player;
import model.tile.tileColor;
import model.tile.tileDeck;
import java.util.Scanner;

import static model.tile.color.*;

public class Main {
    public static void main(String[] args) {
//        GameFrame frame = new GameFrame();

        for(tileColor tColor : tileColor.values()){
            if(tColor == tileColor.RED){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_RED + tColor + i + RESET);
                }
            }
            if(tColor == tileColor.YELLOW){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_YELLOW + tColor + i + RESET);
                }
            }
            if(tColor == tileColor.BLUE){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_BLUE + tColor + i + RESET);
                }
            }
            if(tColor == tileColor.BLACK){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_BLACK + tColor + i + RESET);
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("유저의 이름을 입력하세요 : ");
        String name = scan.next();

        new Player(name);
    }
}
