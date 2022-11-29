package model.game;

import java.util.Scanner;
import model.player.Player;
import model.tile.TileManage;

public class PlayChoice {
    private static TileManage tileListManage;
    static Scanner scan = new Scanner(System.in);

    public static String pickOrShow() {
        System.out.print("\n카드 가져오기 : P or p / 카드 내기 : S or s / 카드 정렬하기 N/n(숫자기준) : ");
        return scan.next();
    }

    public static String addOrEdit() {
        System.out.print("\n새로운 카드리스트 생성 : A or a / 기존 리스트에 추가 : E or e :: ");
        return scan.next();
    }

    public static int generateNoRegister() {
        System.out.print("\n카드를 새로 놓기 - 1 / 임시 배열에 다시 놓기 - 2 / 턴 종료 - 3 :: ");
        return scan.nextInt();
    }

    public static int generate() {
        System.out.print("\n카드를 새로 놓기 - 1 / 기존 배열에 놓기 - 2 / 카드 가져와서 재조합하기 - 3 \n" +
                "배열 나누기 - 4 / 턴 종료하기 - 5 :: ");
        return scan.nextInt();
    }

    public static int tileIndexPick(Player player) {
        tileListManage.tileListPrint(player.tileList, player.name);
        System.out.println();
        System.out.print("몇 번 인덱스를 고르시겠습니까?, 고르지 않으려면 -1을 입력하세요. (0~" + player.tileList.size() + ") : ");
        return scan.nextInt();
    }
}