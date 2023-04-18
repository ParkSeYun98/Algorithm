package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_1238_파티 {
    static final int INF = Integer.MAX_VALUE;

    static int N;
    static int M;
    static int X;
    static int max = Integer.MIN_VALUE;

    static List<Node>[] graph;
    static List<Node>[] graph2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        graph2 = new ArrayList[N+1];
        for(int i=0; i<graph2.length; i++)
            graph2[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, t));
            graph2[e].add(new Node(s, t));
        }

        int[] distance1 = dijkstra(graph);
        int[] distance2 = dijkstra(graph2);

        for(int i=1; i<=N; i++)
            max = Math.max(max, distance1[i] + distance2[i]);

        System.out.println(max);
    }

    static int[] dijkstra(List<Node>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        int[] distance = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(distance, INF);
        distance[X] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;

            for(Node next : graph[now.node]) {
                if(distance[next.node] >= distance[now.node] + next.time) {
                    distance[next.node] = distance[now.node] + next.time;
                    pq.offer(new Node(next.node, distance[next.node]));
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node> {
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}
