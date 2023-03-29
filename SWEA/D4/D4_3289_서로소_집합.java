package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_3289_서로소_집합 {
    private static int n;
    private static int m;

    private static int[] parent;
    private static int[] type;

    private static int[][] arr;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            parent = new int[n+1];
            type = new int[m];
            arr = new int[m][2];
            sb = new StringBuilder();

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                type[i] = Integer.parseInt(st.nextToken());

                for(int j=0; j<2; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            makeSet();
            check();

            System.out.println("#" + tc + " " + sb.toString());
        }
    }

    public static void check() {
        for(int i=0; i<m; i++) {
            if(type[i] == 0) {
                union(arr[i][0], arr[i][1]);
            }
            else {
                if(findSet(arr[i][0]) == findSet(arr[i][1]))
                    sb.append('1');
                else
                    sb.append('0');
            }
        }
    }

    public static void makeSet() {
        for(int i=1; i<=n; i++)
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
}
