package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_더_맵게 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int food : scoville)
                pq.offer(food);

            while(true) {
                if(pq.peek() >= K)
                    break;

                if(pq.size() == 1)
                    return -1;

                int a = pq.poll();
                int b = pq.poll();

                int newFood = a + 2*b;

                pq.offer(newFood);

                answer++;
            }

            return answer;
        }
    }
}
