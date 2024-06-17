package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_5557_1학년 {

    static int N;

    static int[] numArr;

    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        numArr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            numArr[i] = Integer.parseInt(st.nextToken());

        dp = new long[N][21];
        dp[0][numArr[0]] = 1;

        for(int i=1; i<N; i++) {
            for(int j=0; j<=20; j++) {
                if(j - numArr[i] >= 0)
                    dp[i][j] += dp[i-1][j - numArr[i]];

                if(j + numArr[i] <= 20)
                    dp[i][j] += dp[i-1][j + numArr[i]];
            }
        }

        System.out.println(dp[N-2][numArr[N-1]]);
    }
}
