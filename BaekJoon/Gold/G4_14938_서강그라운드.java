package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_14938_서강그라운드 {
    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int m;
    static int r;
    static int max = Integer.MIN_VALUE;

    static int[] items;

    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n+1];

        graph = new ArrayList[n+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++)
            items[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, l));
            graph[b].add(new Node(a, l));
        }

        for(int i=1; i<=n; i++) {
            Dijkstra(i);
        }

        System.out.println(max);
    }

    static void Dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;

            for(Node next : graph[now.node]) {
                if(distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = distance[now.node] + next.weight;
                    pq.offer(new Node(next.node, distance[next.node]));
                }
            }
        }

        int cnt = 0;

        for(int i=1; i<=n; i++) {
            if(distance[i] <= m)
                cnt += items[i];
        }

        max = Math.max(max, cnt);
    }

    static class Node implements Comparable<Node> {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
