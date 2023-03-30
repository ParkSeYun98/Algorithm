package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1251_하나로_프림 {
    private static int N;
    private static double E;
    private static long minCost;

    private static long[] x;
    private static long[] y;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            x = new long[N];
            y = new long[N];;

            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N; i++)
                x[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N; i++)
                y[i] = Integer.parseInt(st.nextToken());

            E = Double.parseDouble(br.readLine());

            graph = new ArrayList[N+1];

            for(int i=0; i<graph.length; i++)
                graph[i] = new ArrayList<>();

            for(long i=0; i<N; i++) {
                for(long j= i+1; j<N; j++) {
                    graph[(int) i].add(new Node((int) j, getDistance(i, j)));
                    graph[(int) j].add(new Node((int) i, getDistance(i, j)));
                }
            }

            minCost = 0;

            Prim();

            System.out.println("#" + tc + " " + Math.round(minCost*E));
        }
    }

    public static void Prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        boolean[] visited = new boolean[N+1];

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
        }
    }

    public static long getDistance(long nodeA, long nodeB) {
        return ((long)Math.pow((x[(int) nodeA] - x[(int) nodeB]), 2) + (long)Math.pow((y[(int) nodeA] - y[(int) nodeB]), 2));
    }

    public static class Node implements Comparable<Node> {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
//            return (int) (this.cost - o.cost);
            return Long.compare(this.cost, o.cost);
        }
    }
}
