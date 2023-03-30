package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_16202_MST_게임 {
    private static int N;
    private static int M;
    private static int K;
    private static int cost;
    private static int cnt;

    private static int[] parent;

    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[M][3];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<2; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());

            graph[i][2] = i+1;
        }

        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        int t = 0;
        while(true) {
            if(t == K)
                break;

            cost = 0;
            parent = new int[N+1];

            make();
            Kruskal(t);

            if(cnt != N-1) {
                for(int i=K-1; i>=t; i--)
                    System.out.print(0 + " ");

                break;
            }
            else
                System.out.print(cost + " ");

            t++;
        }
    }

    public static void make() {
        for(int i=0; i<N; i++)
            parent[i] = i;
    }

    public static int find(int x) {
        if(parent[x] == x)
            return x;
        return find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    public static void Kruskal(int t) {
        cnt = 0;

        for(int i=t; i<M; i++) {
            if(find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                cost += graph[i][2];
                cnt++;
            }

            if(cnt == N-1)
                break;
        }
    }
}
