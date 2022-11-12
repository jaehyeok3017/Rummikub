package game;

import model.player.Player;
import model.tile.tileColor;

import java.util.ArrayList;
import java.util.Scanner;

import static model.tile.color.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tileList = new ArrayList<String>(52);

        for(tileColor tile : tileColor.values()){
            int i = 0;

            if(tile == tileColor.RED){
                for(int j = 1; j < 14; j++){
                    tileList.add(i, FONT_RED + "R" + j + RESET);
                    i++;
                }
            }

            if(tile == tileColor.YELLOW){
                for(int j = 1; j < 14; j++){
                    tileList.add(i, FONT_YELLOW + "Y" + j + RESET);
                    i++;
                }
            }

            if(tile == tileColor.BLUE){
                for(int j = 1; j < 14; j++){
                    tileList.add(i, FONT_BLUE + "B" + j + RESET);
                    i++;
                }
            }

            if(tile == tileColor.WHITE){
                for(int j = 1; j < 14; j++){
                    tileList.add(i, FONT_WHITE + "W" + j + RESET);
                    i++;
                }
            }
        }

        for(int i = 0; i < 52; i++){
            System.out.println(tileList.get(i));
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
