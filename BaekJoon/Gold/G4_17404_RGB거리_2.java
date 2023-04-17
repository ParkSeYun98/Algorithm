package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_17404_RGB거리_2 {
    static int N;

    static int[] result;

    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        result = new int[N+1];

        cost = new int[N+1][3];
        dp = new int[N+1][3];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<3; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<3; i++) {
            // 시작 집 칠하기
            for(int j=0; j<3; j++) {
                if(i == j)
                    dp[1][j] = cost[1][j];
                else
                    dp[1][j] = 1001;
            }

            for(int j=2; j<=N; j++) {
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j-1][2], dp[j-1][0]) + cost[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + cost[j][2];

                if(j == N) {
                    if(i == 0)
                        result[i] = Math.min(dp[N][1], dp[N][2]);
                    else if(i == 1)
                        result[i] = Math.min(dp[N][2], dp[N][0]);
                    else
                        result[i] = Math.min(dp[N][0], dp[N][1]);
                }
            }
        }

        System.out.println(Math.min(result[0], Math.min(result[1], result[2])));
    }
}
