package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_11779_최소비용_구하기_2 {
    static final int INF = Integer.MAX_VALUE;

    static int n;
    static int m;

    static int[] parent;
    static int[] distance;

    static List<Point>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[s].add(new Point(e, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
        parent = new int[n+1];

        Dijkstra(start);

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        sb.append(distance[end]).append('\n');

        while(true) {
            if(parent[end] == 0)
                break;

            cnt += 1;
            stack.push(parent[end]);
            end = parent[end];
        }

        sb.append(cnt).append("\n");

        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");

        System.out.println(sb);
    }

    static void Dijkstra(int start) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(start, 0));

        boolean[] visited = new boolean[n+1];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Point now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;

            for(Point next : graph[now.node]) {
                if(distance[next.node] > distance[now.node] + next.cost) {
                    distance[next.node] = distance[now.node] + next.cost;
                    pq.offer(new Point(next.node, distance[next.node]));
                    parent[next.node] = now.node;
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int node;
        int cost;

        public Point(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
