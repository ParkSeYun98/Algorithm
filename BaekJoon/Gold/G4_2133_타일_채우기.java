package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_2133_타일_채우기 {

    static int N;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[0] = 1;

        for(int i=2; i<=N; i++) {
            dp[i] += dp[i-2] * 3;

            for(int j=i-4; j>=0; j-=2)
                dp[i] += dp[j] * 2;
        }

        System.out.println(dp[N]);
    }
}
