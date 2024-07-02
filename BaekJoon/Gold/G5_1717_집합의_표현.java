package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1717_집합의_표현 {

    static int n, m;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        make();

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(order == 0)
                union(a, b);
            else {
                if(check(a, b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    public static void make() {
        for(int i=0; i<n+1; i++)
            parent[i] = i;
    }

    public static int find(int x) {
        if(x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y)
            parent[y] = x;
        else if(y < x)
            parent[x] = y;
    }

    public static boolean check(int x, int y) {
        return find(x) == find(y);
    }
}
