package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_12852_1로_만들기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i=2; i<=X; i++) {
            dp[i] = dp[i-1] + 1;

            if(i%3 == 0)
                dp[i] = Math.min(dp[i], dp[i/3]+1);

            if(i%2 == 0)
                dp[i] = Math.min(dp[i], dp[i/2]+1);
        }

        System.out.println(dp[X]);
        printTrace(X, dp);
    }

    static void printTrace(int X, int[] dp) {
        if(X == 0)
            return;

        System.out.print(X + " ");

        if(X >= 1 && dp[X-1] == dp[X] - 1)
            printTrace(X-1, dp);
        else if(X%3 == 0 && dp[X/3] == dp[X]-1)
            printTrace(X/3, dp);
        else if(X%2 == 0 && dp[X/2] == dp[X]-1)
            printTrace(X/2, dp);
    }
}
