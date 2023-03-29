package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_18352_특정_거리의_도시_찾기 {
    private static final int INF = Integer.MAX_VALUE;

    private static int N;
    private static int M;
    private static int K;
    private static int X;

    private static boolean[] visited;
    private static int[] distance;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, 1));
        }

        Dijkstra();

        boolean flag = false;

        for(int i=1; i<distance.length; i++) {
            if(distance[i] == K) {
                flag = true;
                System.out.println(i);
            }
        }

        if(!flag)
            System.out.println(-1);
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        visited = new boolean[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        distance[X] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx])
                continue;

            visited[now.idx] = true;

            for(Node next : graph[now.idx]) {
                if(distance[next.idx] > distance[now.idx] + next.cost) {
                    distance[next.idx] = distance[now.idx] + next.cost;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
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
