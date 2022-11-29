package model.game;

import java.util.Scanner;
import model.player.Player;
import model.tile.TileListManage;

public class PlayChoice {
    private static TileListManage tileManage;
    static Scanner scan = new Scanner(System.in);

    public static String playChoicePickOrShow() {
        System.out.print("\n카드 가져오기 : P or p / 카드 내기 : S or s : ");
        return scan.next();
    }

    public static String playChoiceAddOrEdit() {
        System.out.print("\n새로운 카드리스트 생성 : A or a / 기존 리스트에 추가 : E or e :: ");
        return scan.next();
    }

    public static int playChoiceGenerateNoRegister() {
        System.out.print("\n카드를 새로 놓기 - 1 / 임시 배열에 다시 놓기 - 2 / 턴 종료 - 3 :: ");
        return scan.nextInt();
    }

    public static int playChoiceGenerate() {
        System.out.print("\n카드를 새로 놓기 - 1 / 기존 배열에 놓기 - 2 / 카드 가져와서 재조합하기 - 3 \n" +
                "배열 나누기 - 4 / 턴 종료하기 - 5 :: ");
        return scan.nextInt();
    }

    public static int playChoiceTileIndex(Player player) {
        tileManage.playerTileListShow(player.tileList, player.name);
        System.out.println();
        System.out.print("몇 번 인덱스를 고르시겠습니까?, 고르지 않으려면 -1을 입력하세요. (0~" + player.tileList.size() + ") : ");
        return scan.nextInt();
    }
}
