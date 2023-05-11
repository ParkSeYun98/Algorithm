package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_H_Index {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            Arrays.sort(citations);

            for(int h=citations.length; h>=0; h--) {
                int cnt = 0;

                for(int i=0; i<citations.length; i++) {
                    if(citations[i] >= h)
                        cnt++;
                }

                if(cnt >= h) {
                    answer = h;
                    break;
                }
            }

            return answer;
        }
    }
}
