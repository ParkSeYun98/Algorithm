package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class S2_1793_타일링 {

    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new BigInteger[251];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");

        for(int i=2; i<dp.length; i++)
            dp[i] = dp[i-1].add(dp[i-2].multiply(new BigInteger("2")));

        String input;

        while((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);

            System.out.println(dp[num]);
        }
    }
}
