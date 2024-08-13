package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_최솟값_만들기 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++)
            answer += (A[i] * B[B.length-i-1]);

        return answer;
    }
}
