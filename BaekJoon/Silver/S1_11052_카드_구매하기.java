/*
* Memory : 11996 KB
* Time : 104 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_11052_카드_구매하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] P = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++)
            P[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        dp[1] = P[1];

        for(int i=2; i<=N; i++) {
            for(int j=1; j<=i; j++)
                dp[i] = Math.max(dp[i], dp[i-j] + P[j]);
        }

        System.out.println(dp[N]);
    }
}
