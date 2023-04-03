package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_2056_작업 {
    private static int N;

    private static int[] indegree;
    private static int[] dp;

    private static HashMap<Integer, Integer> map;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        indegree = new int[N+1];

        map = new HashMap<>();

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int time = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());

            for(int j=0; j<tmp; j++) {
                int task = Integer.parseInt(st.nextToken());

                graph[task].add(i);
                indegree[i]++;
            }

            map.put(i, time);
        }

        TopologicalSort();

        Print();
    }

    public static void TopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        dp = new int[N+1];

        for(int i=1; i<indegree.length; i++) {
            dp[i] = map.get(i);

            if(indegree[i] == 0)
                queue.offer(i);
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

    public static void Print() {
        int max = -1;

        for(int i=1; i<dp.length; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}
