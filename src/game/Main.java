package game;

import model.player.Player;
import model.tile.tileColor;

import java.util.Scanner;

import static model.tile.color.*;

public class Main {
    public static void main(String[] args) {

        for(tileColor tile : tileColor.values()){
            if(tile == tileColor.RED){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_RED + "R" + i + RESET);
                }
            }
            if(tile == tileColor.YELLOW){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_YELLOW + "Y" + i + RESET);
                }
            }
            if(tile == tileColor.BLUE){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_BLUE + "B" + i + RESET);
                }
            }
            if(tile == tileColor.WHITE){
                for(int i = 1; i < 14; i++){
                    System.out.println(FONT_WHITE + "W" + i + RESET);
                }
            }
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("유저1의 이름을 입력하세요 : ");
        String nameUser1 = scan.next();

        new Player(nameUser1);

        System.out.print("유저2의 이름을 입력하세요 : ");
        String nameUser2 = scan.next();

        new Player(nameUser2);
    }
}
