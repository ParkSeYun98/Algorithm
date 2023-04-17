package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_1774_우주신과의_교감_Prim {
    static int N;
    static int M;
    static double cost = 0;

    static Point[] pointArr;

    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pointArr = new Point[N];
        graph = new ArrayList[N];
        for(int i=0; i< graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double r = Double.parseDouble(st.nextToken())-1;
            double c = Double.parseDouble(st.nextToken())-1;

            pointArr[i] = new Point(i, r, c);
        }

        boolean[] check = new boolean[graph.length];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;

            graph[s].add(new Node(e, 0));
            graph[e].add(new Node(s, 0));
            check[s] = true;
            check[e] = true;
        }

        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                if(check[i] && check[j])
                    continue;

                graph[i].add(new Node(j, getDistance(i, j)));
                graph[j].add(new Node(i, getDistance(i, j)));
            }
        }

        Prim();

        System.out.printf("%.2f\n", cost);
    }

    static double getDistance(int i, int j) {
        return Math.sqrt(Math.pow(pointArr[i].r - pointArr[j].r, 2) + Math.pow(pointArr[i].c - pointArr[j].c, 2));
    }

    static void Prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;
            cost += now.weight;

            for(Node next : graph[now.node]) {
                if(!visited[next.node])
                    pq.offer(next);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        double weight;

        public Node(int node, double weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static class Point {
        int idx;
        double r;
        double c;

        public Point(int idx, double r, double c) {
            this.idx = idx;
            this.r = r;
            this.c = c;
        }
    }
}
