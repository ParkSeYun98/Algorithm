/*
* Memory : 39748 KB
* Time : 424 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_5972_택배_배송 {

    static int N;
    static int M;

    static int[] distance;

    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, C));
            graph[B].add(new Node(A, C));
        }

        Djikstra();
    }

    static void Djikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;

            for (Node next : graph[now.node]) {
                if(distance[next.node] > now.weight + next.weight) {
                    distance[next.node] = now.weight + next.weight;
                    pq.offer(new Node(next.node, distance[next.node]));
                }
            }
        }

        System.out.println(distance[N]);
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
