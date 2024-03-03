package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2225_합분해 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // dp[a][b] = a개의 수(0 ~ a)를 합해 b를 만드는 경우
        int[][] dp = new int[K+1][N+1];

        for(int i=0; i<dp.length; i++) {
            dp[i][0] = 1;

            if(i == 1) {
                for(int j=0; j<dp[0].length; j++)
                    dp[i][j] = 1;
            }
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++)
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1_000_000_000;
        }

        System.out.println(dp[K][N]);
    }
}
