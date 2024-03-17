/*
* Memory : 11696 KB
* Time : 80 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_14469_소가_길을_건너간_이유_3 {

    static int N;

    static PriorityQueue<Cow> pq = new PriorityQueue<>();

    static class Cow implements Comparable<Cow> {
        int start;
        int time;

        public Cow(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Cow o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            pq.offer(new Cow(start, time));
        }

        solve();
    }

    static void solve() {
        int end = 0;

        for(int i=0; i<N; i++) {
            Cow cow = pq.poll();

            if(end < cow.start)
                end = cow.start + cow.time;
            else
                end += cow.time;
        }

        System.out.println(end);
    }
}
