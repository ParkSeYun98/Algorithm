package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_14916_거스름돈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];

        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i=6; i<=n; i++) {
            if(dp[i-2] == 0 && dp[i-5] == 0)
                continue;
            else if(dp[i-2] != 0 && dp[i-5] == 0)
                dp[i] = dp[i-2] + 1;
            else if(dp[i-2] == 0 && dp[i-5] != 0)
                dp[i] = dp[i-5] + 1;
            else
                dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
        }

        if(dp[n] == 0)
            System.out.println(-1);
        else
            System.out.println(dp[n]);
    }
}
