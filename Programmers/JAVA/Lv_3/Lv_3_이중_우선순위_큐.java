package Programmers.JAVA.Lv_3;

import java.util.*;
public class Lv_3_이중_우선순위_큐 {
    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> reversepq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i=0; i<operations.length; i++) {
                String input = operations[i];

                if(input.charAt(0) == 'I') {
                    int inputNum = Integer.parseInt(input.substring(2));

                    pq.offer(inputNum);
                    reversepq.offer(inputNum);
                }
                else if(!pq.isEmpty()) {
                    if(input.charAt(2) == '-') {
                        int min = pq.peek();

                        pq.remove(min);
                        reversepq.remove(min);
                    }
                    else {
                        int max = reversepq.peek();

                        pq.remove(max);
                        reversepq.remove(max);
                    }
                }
            }

            System.out.println(pq);
            System.out.println(reversepq);

            int[] result = new int[2];

            if(pq.isEmpty())
                return result;

            result[1] = pq.poll();
            result[0] = reversepq.poll();

            return result;
        }
    }
}
