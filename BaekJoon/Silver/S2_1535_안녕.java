package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1535_안녕 {

    static int N;

    static int[] plus, minus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        plus = new int[N+1];
        minus = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++)
            minus[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++)
            plus[i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][101];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=100; j++) {
                if(minus[i] < j)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-minus[i]] + plus[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[N][100]);
    }
}
