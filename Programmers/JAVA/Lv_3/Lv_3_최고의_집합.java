package Programmers.JAVA.Lv_3;

import java.util.*;

class Lv_3_최고의_집합 {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int tempA = s / n;

        if(tempA == 0) {
            int[] answerB = {-1};
            return answerB;
        }

        Arrays.fill(answer, tempA);

        int tempB = s % n;

        while(tempB > 0) {
            for(int i=answer.length-1; i>=0; i--) {
                if(tempB == 0)
                    break;

                answer[i]++;
                tempB--;
            }
        }

        return answer;
    }
}
