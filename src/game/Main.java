package game;

import model.player.Player;
import model.tile.tileColor;
import java.util.Scanner;

import static model.tile.color.*;

public class Main {
    public static void main(String[] args) {
        String[] tileList = new String[64];

        for(tileColor tile : tileColor.values()){
            int i = 0;

            if(tile == tileColor.RED){
                for(int j = 1; j < 14; j++){
                    tileList[i++] = FONT_RED + "R" + j + RESET;
                }
            }

            if(tile == tileColor.YELLOW){
                for(int j = 1; j < 14; j++){
                    tileList[i++] = FONT_YELLOW + "Y" + j + RESET;
                }
            }

            if(tile == tileColor.BLUE){
                for(int j = 1; j < 14; j++){
                    tileList[i++] = FONT_BLUE + "B" + j + RESET;
                }
            }

            if(tile == tileColor.WHITE){
                for(int j = 1; j < 14; j++){
                    tileList[i++] = FONT_WHITE + "W" + j + RESET;
                }
            }
        }

        for(int i = 0; i<64; i++){
            System.out.println(tileList[i]);
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
