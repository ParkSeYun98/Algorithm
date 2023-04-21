package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_13913_숨바꼭질_4 {
    static int N;
    static int K;

    static final int[] dp = {1, -1};

    static StringBuilder[] sb = new StringBuilder[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS();

        Stack<Integer> stack = new Stack<>();
        int idx = K;

        while(true) {
            if(idx == N)
                break;

            stack.push(idx);
            idx = Integer.parseInt(sb[idx].toString());
        }
        stack.push(idx);

        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(N, 1));

        int[] visited = new int[100_001];
        visited[N] = 1;

        for(int i=0; i<sb.length; i++)
            sb[i] = new StringBuilder();

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for (int d = 0; d < 2; d++) {
                int nextP = now.p + dp[d];

                if (outofmapCheck(nextP))
                    continue;

                if (visited[nextP] != 0 && visited[nextP] <= now.t+1)
                    continue;

                queue.offer(new Point(nextP, now.t + 1));
                visited[nextP] = now.t+1;
                sb[nextP].append(now.p);
            }

            int nextP2 = now.p * 2;

            if (outofmapCheck(nextP2))
                continue;

            if (visited[nextP2] != 0 && visited[nextP2] <= now.t+1)
                continue;

            queue.offer(new Point(nextP2, now.t+1));
            visited[nextP2] = now.t+1;
            sb[nextP2].append(now.p);
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
