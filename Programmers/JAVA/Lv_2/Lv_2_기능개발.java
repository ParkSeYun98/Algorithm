package Programmers.JAVA.Lv_2;

import java.util.*;


public class Lv_2_기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};

            Queue<Integer> queue = new LinkedList<>();

            for(int i=0; i<progresses.length; i++) {
                int tmp = 100 - progresses[i];

                if(tmp%speeds[i] == 0)
                    queue.offer(tmp/speeds[i]);
                else
                    queue.offer(tmp/speeds[i] + 1);
            }

            int cnt = 1;
            int tmp = queue.poll();
            List<Integer> list = new ArrayList<>();

            while(!queue.isEmpty()) {
                if(queue.peek() <= tmp) {
                    cnt++;
                    queue.poll();
                }
                else {
                    list.add(cnt);
                    tmp = queue.poll();
                    cnt = 1;
                }
            }

            list.add(cnt);

            answer = new int[list.size()];

            for(int i=0; i<answer.length; i++)
                answer[i] = list.get(i);

            return answer;
        }
    }
}
