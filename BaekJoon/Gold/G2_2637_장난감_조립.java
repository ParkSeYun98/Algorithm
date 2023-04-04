package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_2637_장난감_조립 {
    private static int N;
    private static int M;

    private static int[] indegree;
    private static int[] dp;
    private static boolean[] basicCheck;

    private static List<part>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        indegree = new int[N+1];
        dp = new int[N+1];
        basicCheck = new boolean[N+1];

        Arrays.fill(basicCheck, true);

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph[X].add(new part(Y, K));
            indegree[Y]++;
            basicCheck[X] = false;
        }

        topological_Sort();

        Print();
    }

    public static void topological_Sort() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dp[N] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(part next : graph[now]) {
                dp[next.node] += dp[now] * next.cnt;

                if(--indegree[next.node] == 0)
                    queue.offer(next.node);
            }
        }
    }

    public static void Print() {
        for(int i=1; i<dp.length; i++) {
            if(basicCheck[i])
                System.out.println(i + " " + dp[i]);
        }
    }

    public static class part {
        int node;
        int cnt;

        public part(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
}
