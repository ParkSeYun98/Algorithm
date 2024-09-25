package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class S5_10826_피보나치_수_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[n+1];

        dp[0] = BigInteger.ZERO;
        if(n >= 1) {
            dp[1] = BigInteger.ONE;

            for(int i=2; i<=n; i++)
                dp[i] = dp[i-1].add(dp[i-2]);
        }

        System.out.println(dp[n]);
    }
}
