package model.tile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static model.game.GameInitAndEndSet.gameEnd;

public class TileListManage {
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

        noPickTileList.add(i++, new Tile(0, TileColor.WHITE));
        noPickTileList.add(i, new Tile(0, TileColor.RED));
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
            System.out.print(ColorCode.FONT_RED + tile.tileNum + ColorCode.RESET);
        } else if (color == TileColor.WHITE) {
            System.out.print(ColorCode.FONT_WHITE + tile.tileNum + ColorCode.RESET);
        } else if (color == TileColor.BLUE) {
            System.out.print(ColorCode.FONT_BLUE + tile.tileNum + ColorCode.RESET);
        } else if (color == TileColor.YELLOW) {
            System.out.print(ColorCode.FONT_YELLOW + tile.tileNum + ColorCode.RESET);
        }
    }

    public void tileListPrint(ArrayList<Tile> list, String name) {
        System.out.println("\n-----------------\n" + name + " TileList");
        for (int i = 0; i < list.size(); i++) {
            TileColor color = list.get(i).color;

            if (color == TileColor.RED) {
                System.out.print(i + " : [" + ColorCode.FONT_RED + list.get(i).tileNum + ColorCode.RESET + "], ");
            } else if (color == TileColor.WHITE) {
                System.out.print(i + " : [" + ColorCode.FONT_WHITE + list.get(i).tileNum + ColorCode.RESET + "], ");
            } else if (color == TileColor.BLUE) {
                System.out.print(i + " : [" + ColorCode.FONT_BLUE + list.get(i).tileNum + ColorCode.RESET + "], ");
            } else if (color == TileColor.YELLOW) {
                System.out.print(i + " : [" + ColorCode.FONT_YELLOW + list.get(i).tileNum + ColorCode.RESET + "], ");
            }

            if (i % 7 == 0 && i != 0) System.out.println();
        }
    }

    public void tileSortToColor(ArrayList<Tile> tileList) {
    }

    public void tileSortToNumber(ArrayList<Tile> tileList) {
        Collections.sort(tileList, new Comparator<Tile>() {
            @Override
            public int compare(Tile o1, Tile o2) {
                return o1.tileNum - o2.tileNum;
            }
        });
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