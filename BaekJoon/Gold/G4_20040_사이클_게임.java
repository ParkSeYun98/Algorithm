package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_20040_사이클_게임 {
    static int n;
    static int m;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];

        makeSet();

        int result = 0;

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(!union(a, b)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    static void makeSet() {
        for(int i=0; i<parent.length; i++)
            parent[i] = i;
    }

    static int findSet(int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = findSet(parent[x]);
    }

    static boolean union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if(a>b) {
            parent[a] = b;
            return true;
        }
        else if(b>a) {
            parent[b] = a;
            return true;
        }
        else
            return false;
    }
}
