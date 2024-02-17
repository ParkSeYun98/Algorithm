/*
* Memory : 11796 KB
* Time : 80 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1309_동물원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        dp[0] = 3;

        if(N > 1) {
            dp[1] = 7;

            for (int i = 2; i < N; i++)
                dp[i] = (2*dp[i - 1] + dp[i - 2]) % 9901;
        }

        System.out.println(dp[N-1]);
    }
}
