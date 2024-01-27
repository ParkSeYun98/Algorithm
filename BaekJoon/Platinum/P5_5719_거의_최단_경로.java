/*
* Memory : 68256 KB
* Time : 544 ms
* */

package BaekJoon.Platinum;

import java.io.*;
import java.util.*;

public class P5_5719_거의_최단_경로 {

    static int N;
    static int M;
    static int S;
    static int E;

    static int[] distance;

    static boolean[][] check;

    static List<Node>[] graph;
    static List<Integer>[] minList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = null;
        while(!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input, " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            distance = new int[N];
            check = new boolean[N][N];
            graph = new ArrayList[N];
            minList = new ArrayList[N];

            init();

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int U = Integer.parseInt(st.nextToken());
                int V = Integer.parseInt(st.nextToken());
                int P = Integer.parseInt(st.nextToken());

                graph[U].add(new Node(V, P));
            }

            Dijkstra();
            removeMinRoute(S, E);
            Dijkstra();

            if(distance[E] == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(distance[E]);
        }
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            minList[i] = new ArrayList<>();
        }
    }

    static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        pq.offer(new Node(S, distance[S]));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : graph[now.node]) {
                if(check[now.node][next.node])
                    continue;

                if(distance[next.node] > distance[now.node] + next.weight) {
                    distance[next.node] = now.weight + next.weight;
                    pq.offer(new Node(next.node, distance[next.node]));
                    minList[next.node].clear();
                    minList[next.node].add(now.node);
                }
                else if(distance[next.node] == distance[now.node] + next.weight)
                    minList[next.node].add(now.node);
            }
        }
    }

    static void removeMinRoute(int start, int end) {
        if(start == end)
            return;

        for (Integer next : minList[end]) {
            if(!check[next][end]) {
                check[next][end] = true;
                removeMinRoute(start, next);
            }
        }
    }

    static class Node implements Comparable<Node>{
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
