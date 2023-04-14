package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G2_1368_물대기 {
    static int N;
    static int cnt = 0;

    static int[] W;

    static List<Node>[] link;

    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N+1];
        link = new ArrayList[N+1];
        for(int i=0; i<link.length; i++)
            link[i] = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            int cost = Integer.parseInt(br.readLine());

            link[0].add(new Node(i, cost));
            pq.offer(new Node(i, cost));
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1; j<=N; j++) {
                int c = Integer.parseInt(st.nextToken());

                if(i != j) {
                    link[i].add(new Node(j, c));
                    link[j].add(new Node(i, c));
                }
            }
        }

        Prim();

        System.out.println(cnt);
    }

    static void Prim() {
        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;
            cnt += now.cost;

            for(Node next : link[now.node]) {
                if(!visited[next.node])
                    pq.offer(next);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
