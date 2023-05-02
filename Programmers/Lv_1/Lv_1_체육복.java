package Programmers.Lv_1;

import java.util.*;

public class Lv_1_체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            Arrays.sort(lost);
            Arrays.sort(reserve);

            for(int i=0; i<lost.length; i++) {
                for(int j=0; j<reserve.length; j++) {
                    if(lost[i] == reserve[j]) {
                        lost[i] = -1;
                        reserve[j] = -1;
                        answer++;
                        break;
                    }
                }
            }

            for(int i=0; i<lost.length; i++) {
                for(int j=0; j<reserve.length; j++) {
                    if(lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]) {
                        reserve[j] = -1;
                        answer++;
                        break;
                    }
                }
            }

            answer += (n - lost.length);

            return answer;
        }
    }
}
