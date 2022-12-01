package model.game;

import java.util.Scanner;
import model.player.Player;

import static model.board.BoardManage.onBoardTileList;

public class PlayChoice {
    static Scanner scan = new Scanner(System.in);

    public static String pickOrShow() {
        System.out.print("\n카드 가져오기 : P or p / 카드 내기 : S or s / 카드 정렬하기 N/n(숫자기준) / 턴 종료하기 E/e: ");
        return scan.next();
    }

    public static String addOrEdit() {
        System.out.print("\n새로운 카드리스트 생성 : A or a / 기존 리스트에 추가 : E or e :: ");
        return scan.next();
    }

    public static int editCheck() {
        System.out.print("\n기존 배열을 수정하기 : 1 / 배열 나누기 : 2 / 완료 : -1 :: ");
        return scan.nextInt();
    }

    public static int onBoardTileIndexPick(){
        System.out.println();
        System.out.print("인덱스를 고르세요. (0~" + (onBoardTileList.size() - 1) + ") : ");
        return scan.nextInt();
    }

    public static int tileIndexPick(Player player) {
        System.out.println();
        System.out.print("인덱스를 고르세요, 완료하려면 -1을 입력하세요. (0~" + (player.tileList.size() - 1) + ") : ");
        return scan.nextInt();
    }

    public static int detailIndexPick(int index){
        System.out.println();
        System.out.print("수정 기준 인덱스를 고르세요. (0~" + (onBoardTileList.get(index).size() - 1) + ") : ");
        return scan.nextInt();
    }

    public static int workPick() {
        System.out.print("\n요소 앞에 놓기 : 1 / 요소 뒤에 놓기: 2 :: ");
        return scan.nextInt();
    }
}