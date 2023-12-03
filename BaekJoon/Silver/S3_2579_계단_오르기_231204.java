/*
* Memory : 11488 KB
* Time : 76 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_2579_계단_오르기_231204 {

    private static int N;

    private static int[] stairs;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        stairs = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++)
            stairs[i] = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = stairs[1];

        if(N >= 2)
            dp[2] = dp[1] + stairs[2];

        if(N >= 3) {
            for(int i=3; i<=N; i++)
                dp[i] = Math.max(dp[i-3] + stairs[i-1] + stairs[i] , dp[i-2] + stairs[i]);
        }

        System.out.println(dp[N]);
    }
}
