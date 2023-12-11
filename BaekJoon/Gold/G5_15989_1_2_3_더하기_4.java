/*
* Memory : 12656 KB
* Time : 112 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_15989_1_2_3_더하기_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4];

        for(int i=1; i<=3; i++) {
            for(int j=i; j>=1; j--)
                dp[i][j] = 1;
        }

        for(int i=4; i<10001; i++) {
            for(int j=1; j<=3; j++) {
                for(int k=1; k<=j; k++)
                    dp[i][j] += dp[i-j][k];
            }
        }


        for(int tc=0; tc<T; tc++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for(int i=1; i<=3; i++)
                cnt += dp[n][i];

            System.out.println(cnt);
        }

    }
}
