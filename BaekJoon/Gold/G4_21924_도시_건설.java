package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_21924_도시_건설 {
    private static int N;
    private static int M;
    private static long minCost;

    private static boolean[] visited;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        long cost = 0;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
            cost += c;
        }

        visited = new boolean[N+1];

        Prim();

        boolean flag = false;

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                flag = true;
                break;
            }
        }

        if(flag)
            System.out.println(-1);
        else
            System.out.println(cost - minCost);
    }

    public static void Prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        int cnt = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx])
                continue;

            visited[now.idx] = true;
            minCost += now.cost;

            for(Node next : graph[now.idx]) {
                if(!visited[next.idx])
                    pq.offer(next);
            }

            if(++cnt == N+1)
                return;
        }
    }

    public static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
