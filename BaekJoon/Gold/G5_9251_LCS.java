/*
* Memory : 16080 KB
* Time : 112 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_9251_LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strA = br.readLine();
        String strB = br.readLine();

        int[][] dp = new int[strA.length()+1][strB.length()+1];

        for(int i=1; i<=strA.length(); i++) {
            for(int j=1; j<=strB.length(); j++) {
                if(strA.charAt(i-1) == strB.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.println(dp[strA.length()][strB.length()]);
    }
}
