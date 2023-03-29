package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G4_1753_최단경로 {
    private static int V;
    private static int E;
    private static int K;

    private static int[] distance;
    private static boolean[] visited;

    private static List<Point> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        distance = new int[V+1];
        visited = new boolean[V+1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        for(int i=1; i<list.length; i++)
            list[i] = new ArrayList<Point>();

        for(int i=0; i<E; i++) {
            st =  new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Point(v, w));
        }

        Djikstra();

        for(int i=1; i<distance.length; i++) {
            if(distance[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(distance[i]);
        }
    }

    public static void Djikstra() {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(K, 0));

        while(!pq.isEmpty()) {
            Point now = pq.poll();

            if(visited[now.target])
                continue;

            visited[now.target] = true;

            for(Point next : list[now.target]) {
                if(distance[next.target] > now.weight + next.weight) {
                    distance[next.target] = now.weight + next.weight;
                    pq.offer(new Point(next.target, distance[next.target]));
                }
            }
        }
    }

    public static class Point implements Comparable<Point> {
        int target;
        int weight;

        public Point(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point p) {
            return this.weight - p.weight;
        }
    }
}