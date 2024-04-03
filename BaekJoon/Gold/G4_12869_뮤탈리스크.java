package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_12869_뮤탈리스크 {

    static int N, min;

    static int[] hp;

    static int[][] triple = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        hp = new int[3];
        dp = new int[61][61][61];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            hp[i] = Integer.parseInt(st.nextToken());

        DFS(0);

        System.out.println(min);
    }

    static void DFS(int depth) {
        int scv1 = Math.max(hp[0], 0);
        int scv2 = Math.max(hp[1], 0);
        int scv3 = Math.max(hp[2], 0);

        if(depth >= min)
            return;

        if(dp[scv1][scv2][scv3] != 0 && dp[scv1][scv2][scv3] <= depth)
            return;

        if(hp[0]<=0 && hp[1]<=0 && hp[2]<=0) {
            min = Math.min(min, depth);
            return;
        }

        dp[scv1][scv2][scv3] = depth;

        for(int i=0; i<6; i++) {
            for(int j=0; j<3; j++)
                hp[j] -= triple[i][j];

            DFS(depth+1);

            for(int j=0; j<3; j++)
                hp[j] += triple[i][j];
        }
    }
}
