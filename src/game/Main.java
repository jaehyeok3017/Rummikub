package game;

import model.tile.tileColor;

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
    }
}
