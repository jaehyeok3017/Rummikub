package model.tile;

public class Sort {

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left; //왼쪽 커서
        int pr = right; //오른쪽 커서
        int x = a[(pl + pr) / 2]; //피벗
        System.out.println("피벗:" + x);

        //현재 실행 중인 함수의 대상 범위를 나타냄
        System.out.printf("a[%d] ~ a[%d] : {", left, right);
        for (int i = left; i < right; i++) {
            System.out.printf("%d, ", a[i]);
        }
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr) swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(a, left, pr);
        if (right > pl) quickSort(a, pl, right);
    }

}
