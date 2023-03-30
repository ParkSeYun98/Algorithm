package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_18769_그리드_네트워크 {
    private static int R;
    private static int C;
    private static int cost;

    private static boolean visited[];

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph = new ArrayList[R*C + 1];

            for(int i=0; i<graph.length; i++)
                graph[i] = new ArrayList<>();

            for(int i=0; i<R; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<C-1; j++) {
                    int leftright = Integer.parseInt(st.nextToken());

                    int line = i * C;

                    graph[j + line].add(new Node((j + 1) + line, leftright));
                    graph[(j + 1) + line].add(new Node(j + line, leftright));
                }
            }

            for(int i=0; i<R-1; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<C; j++) {
                    int topbottom = Integer.parseInt(st.nextToken());

                    graph[j + i*C].add(new Node(j + (i+1)*C, topbottom));
                    graph[j + (i+1)*C].add(new Node(j + i*C, topbottom));
                }
            }

            cost = 0;
            visited = new boolean[R*C+1];

            Prim(1);
            System.out.println(cost);
        }
    }

    public static void Prim(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        int cnt = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx])
                continue;

            visited[now.idx] = true;
            cost += now.cost;

            for(Node next : graph[now.idx]) {
                if(!visited[next.idx])
                    pq.offer(next);
            }

            if(++cnt == R*C)
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
