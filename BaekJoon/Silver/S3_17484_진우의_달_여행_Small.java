package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_17484_진우의_달_여행_Small {

    static int N, M, min;

    static int[][] space;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        space = new int[N][M];
        dp = new int[N][M][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0)
                    Arrays.fill(dp[i][j], space[i][j]);
                else
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i=1; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(j != 0)
                    dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + space[i][j];

                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + space[i][j];

                if(j != (M-1))
                    dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + space[i][j];
            }
        }

        for(int j=0; j<M; j++) {
            int minVal = dp[N-1][j][0];

            for(int k=1; k<3; k++)
                minVal = Math.min(minVal, dp[N-1][j][k]);

            min = Math.min(min, minVal);
        }

        System.out.println(min);
    }
}
