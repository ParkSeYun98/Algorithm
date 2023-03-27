package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G4_1922_네트워크_연결 {
    private static int N;
    private static int M;
    private static int cost;

    private static int[] parent;

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        cost = 0;
        parent = new int[N];
        graph = new int[M][3];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<3; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, Comparator.comparingInt(o -> o[2]));

        makeSet();
        Kruskal();

        System.out.println(cost);
    }

    private static void makeSet() {
        for(int i=0; i<parent.length; i++)
            parent[i] = i;
    }

    private static void Kruskal() {
        for(int i=0; i<M; i++) {
            if(findSet(graph[i][0] - 1) != findSet(graph[i][1] - 1)) {
                union(graph[i][0]-1, graph[i][1]-1);
                cost += graph[i][2];
            }
        }
    }

    private static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;

    }

    private static int findSet(int x) {
        if(parent[x] == x)
            return x;

        return findSet(parent[x]);
    }
}
