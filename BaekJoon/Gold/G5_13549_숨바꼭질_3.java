package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_13549_숨바꼭질_3 {
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

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        // visited와 구별하기 위해 t를 1부터 스타트하고 나중에 결과 출력때 0을 뺀다
        queue.offer(new Point(N, 1));

        int[] visited = new int[100_001];
        visited[N] = 1;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

//            if (now.p == K) {
//                System.out.println(now.t);
//                return;
//            }

            for (int d = 0; d < 2; d++) {
                int nextP = now.p + dp[d];

                if (outofmapCheck(nextP))
                    continue;

                if (visited[nextP] != 0 && visited[nextP] <= now.t+1)
                    continue;

                queue.offer(new Point(nextP, now.t + 1));
                visited[nextP] = now.t+1;
            }

            int nextP2 = now.p * 2;

            if (outofmapCheck(nextP2))
                continue;

            if (visited[nextP2] != 0 && visited[nextP2] <= now.t)
                continue;

            queue.offer(new Point(nextP2, now.t));
            visited[nextP2] = now.t;
        }

        System.out.println(visited[K]-1);
    }

    static boolean outofmapCheck(int p) {
        return p<0 || p>100_000;
    }

    static class Point {
        int p;
        int t;

        public Point(int p, int t) {
            this.p = p;
            this.t = t;
        }
    }
}
