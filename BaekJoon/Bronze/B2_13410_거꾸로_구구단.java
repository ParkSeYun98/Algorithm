package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2_13410_거꾸로_구구단 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1; i<=K; i++) {
            String tmp = String.valueOf(N*i);
            StringBuilder sb = new StringBuilder(tmp);
            String reverse = sb.reverse().toString();

            pq.offer(Integer.parseInt(reverse));
        }

        System.out.println(pq.poll());
    }
}
