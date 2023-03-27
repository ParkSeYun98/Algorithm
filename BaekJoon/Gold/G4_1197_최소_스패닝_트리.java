package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1197_최소_스패닝_트리 {
    public static int V;
    public static int E;
    public static int cnt;

    public static List<Edge>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        cnt = 0;

        Prim(1);

        System.out.println(cnt);
    }

    public static void Prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        boolean[] visited = new boolean[V+1];

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if(visited[edge.vertex])
                continue;

            visited[edge.vertex] = true;
            cnt += edge.weight;

            for(Edge e : graph[edge.vertex]) {
                if(!visited[e.vertex])
                    pq.add(e);
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        int vertex; // 간선 들어오는 정점
        int weight; // 간선 가중치

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
