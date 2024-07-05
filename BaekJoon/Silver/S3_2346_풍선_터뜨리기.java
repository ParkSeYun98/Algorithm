package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_2346_풍선_터뜨리기 {

    static int N;

    static int[] num;

    static Deque<Balloon> deque;

    static class Balloon {
        int idx;
        int val;

        public Balloon(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(1).append(" ");

        int boom = num[0];

        for(int i=1; i<N; i++)
            deque.add(new Balloon(i+1, num[i]));

        while(!deque.isEmpty()) {
            if(boom > 0) {
                for (int i = 1; i < boom; i++)
                    deque.addLast(deque.pollFirst());

                Balloon next = deque.pollFirst();
                boom = next.val;

                sb.append(next.idx).append(" ");
            }
            else {
                for(int i=1; i<-boom; i++)
                    deque.addFirst(deque.pollLast());

                Balloon next = deque.pollLast();
                boom = next.val;

                sb.append(next.idx).append(" ");
            }
        }

        System.out.println(sb);
    }
}
