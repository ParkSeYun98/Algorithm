package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_16398_행성_연결 {
    private static int N;
    private static long cost = 0;
    private static int idx = 0;

    private static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                int weight = Integer.parseInt(st.nextToken());

                graph[i].add(new Edge(j, weight));
            }
        }

        Prim();

        System.out.println(cost);
    }

    public static void Prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0, 0));

        boolean[] visited = new boolean[N];

        while(!pq.isEmpty()) {
            Edge e = pq.poll();

            if(visited[e.node])
                continue;

            visited[e.node] = true;
            cost += e.cost;

            for(Edge next : graph[e.node]) {
                if (!visited[next.node])
                    pq.offer(next);
            }

            if(++idx == N)
                break;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
