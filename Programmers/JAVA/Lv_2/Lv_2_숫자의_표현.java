package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_숫자의_표현 {

    public int solution(int n) {
        int answer = 0;
        int sum = 0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
            sum += i;

            while(sum > n) {
                int minus = queue.poll();

                sum -= minus;

                if(queue.isEmpty())
                    break;
            }

            if(sum == n)
                answer++;
        }

        return answer;
    }
}
