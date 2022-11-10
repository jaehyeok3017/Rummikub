package model.tile;
public class tileDeck {
    public tileDeck() {
        tileColor[] arr = tileColor.values();
        for(tileColor tColor : arr){
            for(int i = 0; i < 14; i++){
                System.out.println("" + tColor + i);
            }
        }
    }

}
