package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_1788_피보나치_수의_확장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1_000_001];

        dp[0] = 0L;
        dp[1] = 1L;

        for(int i=2; i<=Math.abs(n); i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_000;

        if(n < 0) {
            if(Math.abs(n) % 2 == 0)
                System.out.println(-1);
            else
                System.out.println(1);
        }
        else if(n == 0)
            System.out.println(0);
        else
            System.out.println(1);

        System.out.println(dp[Math.abs(n)]);
    }
}
