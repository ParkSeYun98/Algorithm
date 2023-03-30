package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_14496_그대_그머가_되어 {
    private static final int INF = Integer.MAX_VALUE;

    private static int a;
    private static int b;
    private static int N;
    private static int M;
    private static int result;
    private static boolean flag;

    private static boolean[] visited;
    private static int[] distance;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph[n1].add(new Node(n2, 1));
            graph[n2].add(new Node(n1, 1));
        }

        result = 0;
        visited = new boolean[N+1];
        distance = new int[N+1];

        Arrays.fill(distance, INF);
        distance[a] = 0;

        Dijkstra();

        if(!flag)
            System.out.println(-1);
        else
            System.out.println(distance[b]);
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(a, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.idx == b) {
                flag = true;
                return;
            }

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
