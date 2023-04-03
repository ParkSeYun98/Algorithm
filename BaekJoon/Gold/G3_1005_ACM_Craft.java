package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_1005_ACM_Craft {
    private static int N;
    private static int K;
    private static int W;

    private static int[] indegree;
    private static int[] dp;

    private static Map<Integer, Integer> map;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            indegree = new int[N+1];
            dp = new int[N+1];

            map = new HashMap<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=N; i++)
                map.put(i, Integer.parseInt(st.nextToken()));

            graph = new ArrayList[N+1];
            for(int i=0; i<graph.length; i++)
                graph[i] = new ArrayList<>();

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                graph[X].add(Y);
                indegree[Y]++;
            }

            W = Integer.parseInt(br.readLine());

            TopologicalSort();

            System.out.println(dp[W]);
        }
    }

    public static void TopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<indegree.length; i++) {
            if(indegree[i] == 0)
                queue.offer(i);

            dp[i] = map.get(i);
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : graph[now]) {
                dp[next] = Math.max(dp[next], dp[now] + map.get(next));

                if(--indegree[next] == 0)
                    queue.offer(next);
            }
        }
    }
}
