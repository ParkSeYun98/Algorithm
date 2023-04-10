package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1463_1로_만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=N; i++) {
            if(i%6 == 0)
                dp[i] = Math.min(dp[i-1], Math.min(dp[i/3], dp[i/2])) + 1;
            else if(i%3 == 0)
                dp[i] = Math.min(dp[i-1], dp[i/3]) + 1;
            else if(i%2 == 0)
                dp[i] = Math.min(dp[i-1], dp[i/2]) + 1;
            else
                dp[i] = dp[i-1]+1;
        }

        System.out.println(dp[N]);
    }
}
