package BaekJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5_2887_행성_터널 {
    private static int N;
    private static int cost;

    private static List<int[]> list;

    private static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        graph = new ArrayList[N+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new int[] {i, x, y, z});
        }

        for(int i=1; i<=3; i++) {
            int dimension = i;
            Collections.sort(list, (o1, o2) -> Integer.compare(o1[dimension], o2[dimension]));

            for(int j=1; j<N; j++) {
                int[] nodeA = list.get(j-1);
                int[] nodeB = list.get(j);
                int distance = Math.abs(nodeA[i] - nodeB[i]);

                graph[nodeA[0]].add(new Node(nodeB[0], distance));
                graph[nodeB[0]].add(new Node(nodeA[0], distance));
            }
        }

        Prim();

        System.out.println(cost);
    }

    public static void Prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        boolean[] visited = new boolean[N+1];
        int cnt = 0;
        cost = 0;

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
