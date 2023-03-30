package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1238_Contact {
    private static final int INF = Integer.MAX_VALUE;

    private static int N;
    private static int start;

    private static boolean[] visited;
    private static int[] distance;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc=1; tc<=10; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[101];

            for(int i=0; i<graph.length; i++)
                graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");

            while(st.hasMoreTokens()) {
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                graph[n1].add(new Node(n2, 1));
            }

            visited = new boolean[101];
            distance = new int[101];

            Arrays.fill(distance, INF);
            distance[start] = 0;

            Dijkstra();

            int max = -1;
            int idx = -1;

            for(int i=0; i<=100; i++) {
                if(distance[i] == INF)
                    continue;

                if(max <= distance[i]) {
                    max = distance[i];
                    idx = i;
                }
            }

            System.out.println("#" + tc + " " + idx);
        }
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx])
                continue;

            visited[now.idx] = true;

            for(Node next : graph[now.idx]) {
                if(distance[next.idx] >= distance[now.idx] + next.cost) {
                    distance[next.idx] = distance[now.idx] + next.cost;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node>{
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
