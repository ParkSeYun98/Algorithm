package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G4_1958_LCS_3 {

    static String strA, strB, strC;

    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        strA = br.readLine();
        strB = br.readLine();
        strC = br.readLine();

        dp = new int[strA.length()+1][strB.length()+1][strC.length()+1];

        getLCS();
    }

    static void getLCS() {
        for(int i=1; i<=strA.length(); i++) {
            for(int j=1; j<=strB.length(); j++) {
                for(int k=1; k<=strC.length(); k++) {
                    if(strA.charAt(i-1) == strB.charAt(j-1) && strB.charAt(j-1) == strC.charAt(k-1))
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    else
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                }
            }
        }

        System.out.println(dp[strA.length()][strB.length()][strC.length()]);
    }
}
