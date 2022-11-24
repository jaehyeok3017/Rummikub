package model.game;

import java.util.Scanner;

public class PlayChoice {
    static Scanner scan = new Scanner(System.in);

    public static String playChoicePickOrShow() {
        System.out.print("\n카드 가져오기 : P or p / 카드 내기 : S or s : ");
        return scan.next();
    }

    public static String playChoiceAddOrEdit() {
        System.out.print("\n새로운 카드리스트 생성 : A or a / 기존 리스트에 추가 : E or e :: ");
        return scan.next();
    }

    public static int playChoiceGenerateOrTurnEnd() {
        System.out.print("\n카드를 새로 놓기 - 1 / 임시 배열에 다시 놓기 - 2 / 턴 종료 - 3 :: ");
        return scan.nextInt();
    }
}
