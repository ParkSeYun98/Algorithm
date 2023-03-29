package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_1504_특정한_최단_경로 {
    private static int N;
    private static int E;
    private static int v1;
    private static int v2;

    // 200000 * 1000
    private static final int INF = 200000000;

    private static int[] dist;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i=0; i<N+1; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int routeA = 0;
        int routeB = 0;

        // start -> v1 -> v2 -> end
        routeA += Dijkstra(1, v1);
        routeA += Dijkstra(v1, v2);
        routeA += Dijkstra(v2, N);
        // start -> v1 -> v2 -> end
        routeB += Dijkstra(1, v2);
        routeB += Dijkstra(v2, v1);
        routeB += Dijkstra(v1, N);

        if(routeA >= INF && routeB >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(routeA, routeB));
    }

    public static int Dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            for(Node next : graph[now.idx]) {
                if(dist[next.idx] > dist[now.idx] + next.cost) {
                    dist[next.idx] = dist[now.idx] + next.cost;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        return dist[end];
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
