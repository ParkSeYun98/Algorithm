package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_13301_타일_장식물 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine()) - 1;

        long[] dp = new long[(int) (N+1)];
        dp[0] = 1;

        if(dp.length >= 2)
            dp[1] = 1;
        else {
            System.out.println(4);
            return;
        }

        for(int i=2; i<=N; i++)
            dp[i] = dp[i-2]+dp[i-1];

        System.out.println((4*dp[(int) N]) + 2*dp[(int) (N-1)]);
    }
}
