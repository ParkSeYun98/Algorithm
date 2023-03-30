package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_1446_지름길 {
    private static final int INF = Integer.MAX_VALUE;

    private static int N;
    private static int D;

//    private static boolean[] visited;
    private static int[] distance;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[10001];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        int[] startArr = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, d));

            startArr[i] = s;
        }

//        visited = new boolean[10001];
        distance = new int[10001];
        for(int i=0; i<distance.length; i++)
            distance[i] = i;

        Dijkstra(0);

        distance[0] = 0;

        System.out.println(distance[D]);
    }

    public static void Dijkstra(int start) {
        if(start > D)
            return;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            // 중복여부 체크하면 답 틀리게 나온다.
//            if(visited[now.idx])
//                continue;
//
//            visited[now.idx] = true;

            if(distance[now.idx+1] > distance[now.idx]+1)
                distance[now.idx+1] = distance[now.idx]+1;

            for(Node next : graph[now.idx]) {
                if(distance[next.idx] >= distance[now.idx] + next.cost) {
                    distance[next.idx] = distance[now.idx] + next.cost;
                    pq.offer(new Node(next.idx, distance[next.idx]));
                }
            }
        }

        Dijkstra(start + 1);
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
