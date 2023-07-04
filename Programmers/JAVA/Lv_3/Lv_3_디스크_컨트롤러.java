package Programmers.JAVA.Lv_3;

import java.util.*;

public class Lv_3_디스크_컨트롤러 {

    class Solution {
        public int solution(int[][] jobs) {

            int answer = 0;
            int cnt = 0;
            int start = 0;
            int end = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

            while(true) {

                if(cnt >= jobs.length)
                    break;

                while(start < jobs.length && jobs[start][0] <= end)
                    pq.offer(jobs[start++]);

                if(pq.isEmpty())
                    end = jobs[start][0];
                else {
                    int[] finish = pq.poll();

                    answer += finish[1] - finish[0] + end;
                    end += finish[1];
                    cnt++;
                }
            }

            answer /= jobs.length;

            return (int) Math.floor(answer);
        }
    }
}
