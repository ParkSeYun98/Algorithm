package Programmers.JAVA.Lv_3;

import java.util.*;

public class Lv_3_숫자_게임 {

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int bIdx = B.length-1;
        int point = 0;

        for(int i=A.length-1; i>=0; i--) {
            if(B[bIdx] > A[i]) {
                point++;
                bIdx--;
            }
        }

        return point;
    }
}
