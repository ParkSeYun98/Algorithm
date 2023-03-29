package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_1251_하나로 {
    private static int N;
    private static double E;

    private static long[] x;
    private static long[] y;
    private static long[] parent;

    private static long[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            x = new long[N];
            y = new long[N];
            parent = new long[N];
            graph = new long[(N*(N-1))/2][3];

            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N; i++)
                x[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N; i++)
                y[i] = Integer.parseInt(st.nextToken());

            E = Double.parseDouble(br.readLine());

            int idx = 0;

            for(long i=0; i<N; i++) {
                for(long j= i+1; j<N; j++) {
                    graph[idx][0] = i;
                    graph[idx][1] = j;
                    graph[idx][2] = getDistance(i, j);
                    idx++;
                }
            }

            Arrays.sort(graph, (o1, o2) -> Long.compare(o1[2], o2[2]));

            makeSet();

            long cost = 0;

            System.out.println("#" + tc + " " + Math.round(Kruskal(cost)*E));
        }
    }

    public static long getDistance(long nodeA, long nodeB) {
        return ((long)Math.pow((x[(int) nodeA] - x[(int) nodeB]), 2) + (long)Math.pow((y[(int) nodeA] - y[(int) nodeB]), 2));
    }

    public static void makeSet() {
        for(int i=0; i<N; i++)
            parent[i] = i;
    }

    public static long findSet(long x) {
        if(parent[(int) x] == x)
            return x;
        else
            return findSet(parent[(int) x]);
    }

    public static void union(long x, long y) {
        x = findSet(x);
        y = findSet(y);

        if(x > y)
            parent[(int) x] = y;
        else
            parent[(int) y] = x;
    }

    public static long Kruskal(long cost) {
        int cnt = 0;

        for(int i=0; i<N*(N-1)/2; i++) {
            if(findSet(graph[i][0]) != findSet(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                cost += graph[i][2];
                cnt++;
            }

            if(cnt == N-1)
                break;
        }

        return cost;
    }
}
