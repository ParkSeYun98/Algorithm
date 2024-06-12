package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2240_자두나무 {

    static int T, W, ans;

    static int[] fall;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        ans = 0;
        fall = new int[T+1];
        dp = new int[T+1][W+1];

        for(int i=1; i<=T; i++)
            fall[i] = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            for(int j=0; j<=W; j++) {
                if(j == 0) {
                    int now = 1;

                    if(fall[i] == now)
                        dp[i][j] = dp[i-1][j] + 1;
                    else
                        dp[i][j] = dp[i-1][j];

                    continue;
                }

                int now = 0;

                if(j % 2 == 0)
                    now = 1;
                else
                    now = 2;

                if(fall[i] == now)
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j] + 1);
                else
                    dp[i][j] = Math.max(dp[i-1][j-1] + 1, dp[i-1][j]);

                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }
}
