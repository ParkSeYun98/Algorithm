package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S1_11286_절댓값_힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                int A = Math.abs(o1);
                int B = Math.abs(o2);

                if(A == B)
                    return o1-o2;
                return A-B;
            }
        });

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(br.readLine());

            if(now == 0) {
                if(pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            }
            else
                pq.add(now);
        }
    }
}
