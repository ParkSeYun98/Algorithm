package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_2748_피보나치_수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];

        dp[0] = 0L;
        dp[1] = 1L;

        for(int i=2; i<dp.length; i++)
            dp[i] = dp[i-2] + dp[i-1];

        System.out.println(dp[n]);
    }
}
