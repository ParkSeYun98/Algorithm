package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_4883_삼각_그래프 {

    static int N;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = 1;

        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0)
                return;

            dp = new int[N][3];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                dp[i][0] = Integer.parseInt(st.nextToken());
                dp[i][1] = Integer.parseInt(st.nextToken());
                dp[i][2] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<N; i++) {
                if(i == 1) {
                    for(int j=0; j<3; j++) {
                        if(j==0)
                            dp[i][0] += dp[i-1][1];
                        else {
                            dp[i][j] += Math.min(dp[i][j-1], Math.min(dp[i-1][1], dp[i-1][1] + dp[i-1][2]));
                        }
                    }
                }
                else {
                    dp[i][0] += Math.min(dp[i-1][0], dp[i-1][1]);
                    dp[i][1] += Math.min(Math.min(dp[i][0], dp[i-1][0]), Math.min(dp[i-1][1], dp[i-1][2]));
                    dp[i][2] += Math.min(dp[i][1],Math.min(dp[i-1][1], dp[i-1][2]));
                }
            }

            System.out.println(tc++ + ". " + dp[N-1][1]);
        }
    }
}
