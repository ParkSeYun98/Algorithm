package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_귤_고르기 {

    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);

        int[] cntArr = new int[tangerine[tangerine.length-1]+1];

        for(int i=0; i<tangerine.length; i++)
            cntArr[tangerine[i]]++;

        Arrays.sort(cntArr);

        int cnt = 0;

        for(int i=cntArr.length-1; i>=0; i--) {
            if(cntArr[i] == 0)
                break;

            if(k <= 0)
                break;

            cnt++;
            k -= cntArr[i];
        }

        return cnt;
    }
}
