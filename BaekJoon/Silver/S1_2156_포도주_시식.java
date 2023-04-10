package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_2156_포도주_시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] grapeJuice = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1; i<=n; i++)
            grapeJuice[i] = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = grapeJuice[1];

        if(n >= 2)
            dp[2] = dp[1] + grapeJuice[2];

        if(n >= 3) {
            for(int i=3; i<=n; i++) {
                dp[i] = Math.max(dp[i-1], grapeJuice[i] + dp[i-2]);
                dp[i] = Math.max(dp[i], grapeJuice[i] + grapeJuice[i-1] + dp[i-3]);
            }
        }

        System.out.println(dp[n]);
    }
}
