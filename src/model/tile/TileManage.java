package model.tile;

import java.util.*;

import static model.game.GameInitAndEndSet.gameEnd;

public class TileManage {
    public static ArrayList<Tile> noPickTileList = new ArrayList<Tile>(106);

    public void push() {
        int i = 0;
        for (int r = 0; r < 2; r++) {
            for (TileColor tile : TileColor.values()) {
                if (tile == TileColor.RED) {
                    for (int j = 1; j < 14; j++) {
                        noPickTileList.add(i, new Tile(j, TileColor.RED));
                        i++;
                    }
                }

                if (tile == TileColor.YELLOW) {
                    for (int j = 1; j < 14; j++) {
                        noPickTileList.add(i, new Tile(j, TileColor.YELLOW));
                        i++;
                    }
                }

                if (tile == TileColor.BLUE) {
                    for (int j = 1; j < 14; j++) {
                        noPickTileList.add(i, new Tile(j, TileColor.BLUE));
                        i++;
                    }
                }

                if (tile == TileColor.WHITE) {
                    for (int j = 1; j < 14; j++) {
                        noPickTileList.add(i, new Tile(j, TileColor.WHITE));
                        i++;
                    }
                }
            }
        }

        noPickTileList.add(i++, new Tile(999, TileColor.WHITE));
        noPickTileList.add(i, new Tile(999, TileColor.RED));
    }

    public Tile pop() {
        int listSize = getStackSize(noPickTileList);
        Tile popElement = noPickTileList.get(listSize - 1);
        noPickTileList.remove(listSize - 1);

        return popElement;
    }

    public static int getStackSize(ArrayList<Tile> list) {
        return list.size();
    }

    public void tilePrint(Tile tile){
        TileColor color = tile.color;

        if (color == TileColor.RED) {
            if(tile.number == 999) System.out.print(ColorCode.FONT_RED + "JOKER" + ColorCode.RESET);
            else System.out.print(ColorCode.FONT_RED + tile.number + ColorCode.RESET);
        }
        else if (color == TileColor.WHITE) {
            if(tile.number == 999) System.out.print("[" + ColorCode.FONT_WHITE + "JOKER" + ColorCode.RESET + "]");
            System.out.print(ColorCode.FONT_WHITE + tile.number + ColorCode.RESET);
        }
        else if (color == TileColor.BLUE) {
            System.out.print(ColorCode.FONT_BLUE + tile.number + ColorCode.RESET);
        }
        else if (color == TileColor.YELLOW) {
            System.out.print(ColorCode.FONT_YELLOW + tile.number + ColorCode.RESET);
        }
    }

    public void tileLinkListPrint(ArrayList<LinkedList<Tile>> list){
        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).size(); j++){
                TileColor color = list.get(i).get(j).color;

                if (color == TileColor.RED) {
                    if(list.get(i).get(j).number == 999) System.out.print("[" + ColorCode.FONT_RED + "JOKER" + ColorCode.RESET + "]");
                    else System.out.print("[" + ColorCode.FONT_RED + list.get(i).get(j).number + ColorCode.RESET + "]");
                }
                else if (color == TileColor.WHITE) {
                    if(list.get(i).get(j).number == 999) System.out.print("[" + ColorCode.FONT_WHITE + "JOKER" + ColorCode.RESET + "]");
                    else System.out.print("[" + ColorCode.FONT_WHITE + list.get(i).get(j).number + ColorCode.RESET + "]");
                }
                else if (color == TileColor.BLUE) {
                    System.out.print("[" + ColorCode.FONT_BLUE + list.get(i).get(j).number + ColorCode.RESET + "]");
                }
                else if (color == TileColor.YELLOW) {
                    System.out.print("[" + ColorCode.FONT_YELLOW + list.get(i).get(j).number + ColorCode.RESET + "]");
                }
            }

            if(list.get(i).size() > 1) System.out.print("   ");
            if(list.get(i).size() > 1 && i % 5 == 0) System.out.println();
        }

        System.out.println();
    }

    public void tileLinkPrint(LinkedList<Tile> tile){
        for(int i = 0; i < tile.size(); i++){
            TileColor color = tile.get(i).color;

            if (color == TileColor.RED) {
                if(tile.get(i).number == 999) System.out.print("[" + ColorCode.FONT_RED + "JOKER" + ColorCode.RESET + "]");
                else System.out.print("[" + ColorCode.FONT_RED + tile.get(i).number + ColorCode.RESET + "]");
            }
            else if (color == TileColor.WHITE) {
                if(tile.get(i).number == 999) System.out.print("[" + ColorCode.FONT_WHITE + "JOKER" + ColorCode.RESET + "]");
                else System.out.print("[" + ColorCode.FONT_WHITE + tile.get(i).number + ColorCode.RESET + "]");
            }
            else if (color == TileColor.BLUE) {
                System.out.print("[" + ColorCode.FONT_BLUE + tile.get(i).number + ColorCode.RESET + "]");
            }
            else if (color == TileColor.YELLOW) {
                System.out.print("[" + ColorCode.FONT_YELLOW + tile.get(i).number + ColorCode.RESET + "]");
            }
        }
    }

    public void tileListPrint(ArrayList<Tile> list, String name) {
        System.out.println("\n-----------------\n" + name + " TileList");
        if(Objects.equals(name, "AI") || Objects.equals(name, "ai")){
            System.out.println("응애 나 인공지능");
            tileSortToNumber(list);


            for(int i = 0; i < list.size(); i++){ //타일 색깔이 다르고 타일 숫자가 같을 때 타일 3개 내기 ex) 빨강1, 노랑1, 파랑1
                if(Objects.equals(list.get(i), list.get(i + 1)) && Objects.equals(list.get(i + 1), list.get(i + 2))){
                    //타일 내기
                }
            }




            /*
            if(){ //낼 수 있는 타일이 없을 때
                AIList.addLast(); //타일 가져가기
            }
            */


        }
        for (int i = 0; i < list.size(); i++) {
            TileColor color = list.get(i).color;

            if (color == TileColor.RED) {
                if(list.get(i).number == 999) System.out.print(i + ":[" + ColorCode.FONT_RED + "JOKER" + ColorCode.RESET + "], ");
                else System.out.print(i + ":[" + ColorCode.FONT_RED + list.get(i).number + ColorCode.RESET + "], ");
            }
            else if (color == TileColor.WHITE) {
                if(list.get(i).number == 999) System.out.print(i + ":[" + ColorCode.FONT_WHITE + "JOKER" + ColorCode.RESET + "], ");
                else System.out.print(i + ":[" + ColorCode.FONT_WHITE + list.get(i).number + ColorCode.RESET + "], ");
            }
            else if (color == TileColor.BLUE) {
                System.out.print(i + ":[" + ColorCode.FONT_BLUE + list.get(i).number + ColorCode.RESET + "], ");
            }
            else if (color == TileColor.YELLOW) {
                System.out.print(i + ":[" + ColorCode.FONT_YELLOW + list.get(i).number + ColorCode.RESET + "], ");
            }
        }
    }

    public void tileSortToColor(ArrayList<Tile> tileList) {
    }

    public void tileSortToNumber(ArrayList<Tile> tileList) {
        tileList.sort(new Comparator<Tile>() {
            @Override
            public int compare(Tile o1, Tile o2) {
                return o1.number - o2.number;
            }
        });
        System.out.println("정렬 완료");
    }

    public void tileShuffle(ArrayList<Tile> tileList) {
        for (int i = 0; i < 3; i++) {
            Collections.shuffle(tileList);
        }
    }

    public Tile noPickTileDivide(ArrayList<Tile> playerTileList) {
        // 가져갈 카드가 있는 경우
        playerTileList.add(pop());

        int playerTileListSize = getStackSize(playerTileList);
        return playerTileList.get(playerTileListSize - 1);
    }

    public Boolean isTileListNull(ArrayList<Tile> tileList) {
        int tileListSize = getStackSize(tileList);

        // 가져갈 카드가 없어서 게임이 끝나야 하는 경우
        if (tileListSize < 0) {
            gameEnd(0);
            return true;
        }

        else return false;
    }
}