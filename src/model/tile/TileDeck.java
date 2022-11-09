package model.tile;
public class tileDeck {
    public tileDeck() {
        for(tileColor color : tileColor.values()){
            for(int i = 0; i <= 13; i++){
                Tile tile = new Tile(i, color);
            }
        }
    }

}
