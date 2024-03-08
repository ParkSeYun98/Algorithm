package SWEA.D3;

import java.util.*;

class D3_연습문제_야근_지수 {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int work : works)
            pq.offer(work);

        while(n > 0) {
            int now = pq.poll();

            if(now == 0)
                break;

            pq.offer(now-1);
            n--;
        }

        for(int work : pq)
            answer += Math.pow(work, 2);

        return answer;
    }
}
