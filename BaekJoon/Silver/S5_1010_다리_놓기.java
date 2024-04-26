package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_1010_다리_놓기 {

    static int N, M, cnt;

    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        dp = new int[30][30];

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            System.out.println(combination(M, N));
        }
    }

    static int combination(int m, int n) {
        if(dp[m][n] > 0)
            return dp[m][n];

        if(m == n || n == 0)
            return dp[m][n] = 1;

        return dp[m][n] = combination(m-1, n-1) + combination(m-1, n);
    }
}
