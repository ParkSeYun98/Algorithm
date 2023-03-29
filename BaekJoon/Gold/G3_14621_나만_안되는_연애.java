package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_14621_나만_안되는_연애 {
    private static int N;
    private static int M;
    private static int cnt;
    private static int result;

    private static String[] school;
    private static boolean[] visited;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        school = new String[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++)
            school[i] = st.nextToken();

        graph = new ArrayList[N+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if(!school[u].equals(school[v])) {
                graph[u].add(new Node(v, d));
                graph[v].add(new Node(u, d));
            }
        }

        cnt = 0;
        result = 0;
        visited = new boolean[N+1];

        Prim();

        boolean flag = false;

        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                flag = true;
                break;
            }
        }

        if(flag)
            System.out.println(-1);
        else
            System.out.println(result);

    }

    public static void Prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx])
                continue;

            visited[now.idx] = true;
            result += now.cost;

            for(Node next : graph[now.idx]) {
                if(!visited[next.idx])
                    pq.offer(next);
            }

            if(++cnt == N+1)
                break;
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
