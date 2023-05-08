package Programmers.JAVA.Lv_2;

import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class Lv_2_프로세스 {
    class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            Queue<Integer> wait = new LinkedList<>();
            Queue<Integer> index = new LinkedList<>();

            int idx = 0;

            for(int i=0; i<priorities.length; i++) {
                wait.offer(priorities[i]);
                index.offer(idx);
                idx++;
            }

            int max = Collections.max(wait);

            while(!wait.isEmpty()) {
                int a = wait.poll();
                int b = index.poll();

                if(a == max && b == location) {
                    answer++;
                    return answer;
                }
                else if(a == max) {
                    answer += 1;
                    max = Collections.max(wait);
                }
                else {
                    wait.offer(a);
                    index.offer(b);
                }
            }


            return answer;
        }
    }
}
