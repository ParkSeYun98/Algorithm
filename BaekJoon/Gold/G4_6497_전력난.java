package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_6497_전력난 {
    private static int m;
    private static int n;
    private static int min;

    private static int[] parent;

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(m == 0 && n == 0)
                return;

            graph = new int[n][3];
            int cost = 0;

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<3; j++)
                    graph[i][j] = Integer.parseInt(st.nextToken());

                cost += graph[i][2];
            }

            Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

            min = 0;
            parent = new int[m+1];

            make();
            Kruskal();

            System.out.println(cost - min);
        }
    }

    public static void make() {
        for(int i=0; i<m; i++)
            parent[i] = i;
    }

    public static int find(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    public static void Kruskal() {
        int cnt = 0;

        for(int i=0; i<n; i++) {
            if(find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                min += graph[i][2];
                cnt++;
            }

            if(cnt == m-1)
                return;
        }
    }
}
