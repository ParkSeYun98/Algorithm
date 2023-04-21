package BaekJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5_17071_숨바꼭질_5 {
    static int N;
    static int K;

    static final int[] dp = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();
    }

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        boolean[][] visited = new boolean[500_001][2];
        visited[N][0] = true;

        int t = 0;

        while(!queue.isEmpty()) {
            if(outofmapCheck(K)) {
                System.out.println(-1);
                return;
            }

            if(visited[K][t%2]) {
                System.out.println(t);
                return;
            }

//            for(int i=0; i<queue.size(); i++) {
            // poll하면 queue.size가 계속 변하니까 고정시키는 것임..
            for(int i=0, size=queue.size(); i<size; i++) {
                int now = queue.poll();

                for(int d=0; d<2; d++) {
                    int next = now + dp[d];

                    if(outofmapCheck(next))
                        continue;

                    if(visited[next][(t+1)%2])
                        continue;

                    queue.offer(next);
                    visited[next][(t+1)%2] = true;
                }

                int next = now * 2;

                if(outofmapCheck(next))
                    continue;

                if(visited[next][(t+1)%2])
                    continue;

                queue.offer(next);
                visited[next][(t+1)%2] = true;
            }

            t++;
            K += t;
        }

        System.out.println(-1);
    }

    static boolean outofmapCheck(int next) {
        return next<0 || next>=500_001;
    }
}
