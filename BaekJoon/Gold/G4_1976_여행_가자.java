package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1976_여행_가자 {

    static int N, M;

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];

        init();

        for(int i=1; i<N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1; j<N+1; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        boolean flag = true;
        int start = Integer.parseInt(st.nextToken());

        for(int j=1; j<M; j++) {
            int now = Integer.parseInt(st.nextToken());

            if(find(start) != find(now)) {
                flag = false;
                break;
            }

            start = now;
        }

        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static void init() {
        for(int i=1; i<N+1; i++)
            parent[i] = i;
    }

    static int find(int x) {
        if(x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            if(x > y)
                parent[x] = y;
            else
                parent[y] = x;
        }
    }
}
