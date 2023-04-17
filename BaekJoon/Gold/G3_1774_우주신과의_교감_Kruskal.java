package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_1774_우주신과의_교감_Kruskal {
    static int N;
    static int M;
    static double cost = 0;

    static int[] parent;
    static Point[] pointArr;

    static double[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        pointArr = new Point[N+1];
        graph = new double[N*(N-1)/2][3];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            double r = Double.parseDouble(st.nextToken());
            double c = Double.parseDouble(st.nextToken());

            pointArr[i] = new Point(i, r, c);
        }

        makeSet();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }

        int idx = 0;

        for(int i=1; i<=N-1; i++) {
            for(int j=i+1; j<=N; j++) {
                graph[idx][0] = i;
                graph[idx][1] = j;
                graph[idx][2] = getDistance(i, j);

                idx++;
            }

        }

        Arrays.sort(graph, (o1, o2) -> Double.compare(o1[2], o2[2]));

        Kruskal();

        System.out.printf("%.2f\n", cost);
    }

    static double getDistance(int i, int j) {
        return Math.sqrt(Math.pow(pointArr[i].r - pointArr[j].r, 2) + Math.pow(pointArr[i].c - pointArr[j].c, 2));
    }

    static void makeSet() {
        for(int i=1; i<=N; i++)
            parent[i] = i;
    }

    static int findSet(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = findSet(parent[x]);
    }

    static void union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if(a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    static void Kruskal() {
        for(int i=0; i<graph.length; i++) {
            if(findSet((int) graph[i][0]) != findSet((int) graph[i][1])) {
                union((int) graph[i][0], (int) graph[i][1]);
                cost += graph[i][2];
            }
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
