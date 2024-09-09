package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_숫자_변환하기 {
    public int solution(int x, int y, int n) {
        int[] dp = new int[y+1];

        Arrays.fill(dp, -1);
        dp[x] = 0;

        for(int i=0; i<dp.length; i++) {
            if(dp[i] == -1)
                continue;

            if(i+n <= y) {
                if(dp[i+n] == -1)
                    dp[i+n] = dp[i]+1;
                else
                    dp[i+n] = Math.min(dp[i]+1, dp[i+n]);
            }

            if(2*i <= y) {
                if(dp[2*i] == -1)
                    dp[2*i] = dp[i]+1;
                else
                    dp[2*i] = Math.min(dp[i]+1, dp[2*i]);
            }

            if(3*i <= y) {
                if(dp[3*i] == -1)
                    dp[3*i] = dp[i]+1;
                else
                    dp[3*i] = Math.min(dp[i]+1, dp[3*i]);
            }
        }

        return dp[y];
    }
}
