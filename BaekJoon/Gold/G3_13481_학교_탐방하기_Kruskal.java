package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G3_13481_학교_탐방하기_Kruskal {

    private static int N;
    private static int M;
    private static int minFatigue = 0;
    private static int maxFatigue = 0;

    private static int[] parent;

    private static List<Edge> road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken()) + 1;

        parent = new int[N+1];
        road = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            road.add(new Edge(A, B, C));
        }

        Collections.sort(road, (e1, e2) -> e1.weight - e2.weight);

        makeSet();
        maxKruskal();
        makeSet();
        minKruskal();

        System.out.println(maxFatigue - minFatigue);
    }

    public static void maxKruskal() {
        for(int i=0; i<road.size(); i++) {
            Edge now = road.get(i);

            if(findSet(now.start) != findSet(now.end)) {
                union(now.start, now.end);

                if(now.weight == 0)
                    maxFatigue++;
            }
        }

        maxFatigue *= maxFatigue;
    }

    public static void minKruskal() {
        for(int i=road.size()-1; i>=0; i--) {
            Edge now = road.get(i);

            if(findSet(now.start) != findSet(now.end)) {
                union(now.start, now.end);

                if(now.weight == 0)
                    minFatigue++;
            }
        }

        minFatigue *= minFatigue;
    }

    public static void makeSet() {
        for(int i=1; i<=N; i++)
            parent[i] = i;
    }

    public static int findSet(int x) {
        if(x == parent[x])
            return x;

        return parent[x] = findSet(parent[x]);
    }

    public static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    public static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
