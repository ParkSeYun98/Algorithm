package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_주식가격 {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            Queue<Integer> queue = new LinkedList<>();

            for(int price : prices)
                queue.offer(price);

            int idx = 0;

            while(!queue.isEmpty()) {
                int now = queue.poll();

                boolean flag = false;

                for(int i=idx; i<prices.length; i++) {
                    if(now > prices[i]) {
                        flag = true;
                        answer[idx] = i - idx;
                        break;
                    }
                }

                if(!flag)
                    answer[idx] = prices.length-idx-1;

                idx++;
            }

            return answer;
        }
    }
}
