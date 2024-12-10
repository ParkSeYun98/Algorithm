package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_17396_백도어 {

    static int N, M;

    static int[] sight;
    static long[] dist;

    static List<Node>[] graph;

    static class Node implements Comparable<Node> {
        int node;
        long time;

        public Node(int node, long time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.time - o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         st = new StringTokenizer(br.readLine(), " ");
         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         sight = new int[N];
         dist = new long[N];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

         st = new StringTokenizer(br.readLine(), " ");
         for(int i=0; i<N; i++)
             sight[i] = Integer.parseInt(st.nextToken());

         graph = new ArrayList[N];

         for(int i=0; i<graph.length; i++)
             graph[i] = new ArrayList<>();

         for(int i=0; i<M; i++) {
             st = new StringTokenizer(br.readLine(), " ");
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             int t = Integer.parseInt(st.nextToken());

             graph[a].add(new Node(b, t));
             graph[b].add(new Node(a, t));
         }

         Djikstra();

         if(dist[N-1] == Long.MAX_VALUE)
             System.out.println(-1);
         else
             System.out.println(dist[N-1]);
    }

    static void Djikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));

        boolean[] visited = new boolean[N];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;

            for (Node next : graph[now.node]) {
                if((next.node!=(N-1)) && (sight[next.node]==1))
                    continue;

                if(dist[next.node] > dist[now.node] + next.time) {
                    dist[next.node] = dist[now.node] + next.time;
                    pq.offer(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
