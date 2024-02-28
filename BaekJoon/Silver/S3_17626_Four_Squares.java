/*
* Memory : 12376 KB
* Time : 124 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_17626_Four_Squares {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int temp = 1;

        for (int i = 2; i < dp.length; i++) {
            if (getSquare(temp+1) == i) {
                temp++;
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[(int) (i - getSquare(temp))] + dp[getSquare(temp)];

            if(dp[i] == 1)
                temp = i;

            for(int j=temp; j>=1; j--)
                dp[i] = Math.min(dp[i], dp[i - getSquare(j)]+1);
        }

        System.out.println(dp[n]);
    }

    static int getSquare(int input) {
        return (int) Math.pow(input, 2);
    }
}
