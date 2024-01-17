package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S1_15903_카드_합체_놀이 {

    static int n;
    static int m;

    static long[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        card = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++)
            card[i] = Long.parseLong(st.nextToken());

        getMinimumScore();
    }

    static void getMinimumScore() {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0;

        for (long i : card)
            pq.offer(i);

        for(int i=0; i<m; i++) {
            long numA = pq.poll();
            long numB = pq.poll();

            for(int j=0; j<2; j++)
                pq.offer(numA+numB);
        }

        while(!pq.isEmpty())
            sum += pq.poll();

        System.out.println(sum);
    }
}
