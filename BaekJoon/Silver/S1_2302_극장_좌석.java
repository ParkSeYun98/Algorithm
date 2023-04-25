package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_2302_극장_좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++)
            dp[i] = dp[i-1] + dp[i-2];

        if(M == 0) {
            System.out.println(dp[N]);
            System.exit(0);
        }
        else if(M == N) {
            System.out.println(1);
            System.exit(0);
        }

        int[] vip = new int[M+1];

        for(int i=1; i<=M; i++)
            vip[i] = Integer.parseInt(br.readLine());

        int result = 1;

        for(int i=1; i<vip.length; i++)
            result *= dp[vip[i] - vip[i-1] - 1];

        result *= dp[N - vip[M]];

        System.out.println(result);
    }
}
