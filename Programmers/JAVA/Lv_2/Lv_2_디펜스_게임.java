package Programmers.JAVA.Lv_2;

import java.util.*;

class Lv_2_디펜스_게임 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int cnt = 0;

        for(int i=0; i<enemy.length; i++) {
            pq.offer(enemy[i]);
            n -= enemy[i];

            if(n < 0) {
                if(k > 0) {
                    k--;
                    n += pq.poll();
                }
                else
                    break;
            }

            cnt++;
        }

        return cnt;
    }
}
