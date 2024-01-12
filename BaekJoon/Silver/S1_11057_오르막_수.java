package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_11057_오르막_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+2][10];

        for(int i=0; i<10; i++)
            dp[1][i] = 1;

        for(int i=2; i<=N+1; i++) {
            for(int j=0; j<10; j++) {
                for(int k=j; k<10; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[N+1][0] % 10007);
    }
}
