package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_7465_창용_마을_무리의_개수 {
    private static int N;
    private static int M;

    private static int[] parent;

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            arr = new int[M][2];

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<2; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            makeSet();
            Kruskal();

            int[] count = new int[N+1];

            for(int i=1; i<=N; i++) {
                count[findSet(i)]++;
            }

            int result = 0;

            for(int i=0; i<count.length; i++) {
                if(count[i] != 0)
                    result++;
            }

            System.out.println("#" + tc + " " + result);
        }
    }

    public static void makeSet() {
        for(int i=0; i<N; i++)
            parent[i] = i;
    }

    public static int findSet(int x) {
        if(parent[x] == x)
            return x;
        else
            return findSet(parent[x]);
    }

    public static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    public static void Kruskal() {
        for(int i=0; i<M; i++) {
            if(findSet(arr[i][0]) != findSet(arr[i][1]))
                union(arr[i][0], arr[i][1]);
        }
    }
}
