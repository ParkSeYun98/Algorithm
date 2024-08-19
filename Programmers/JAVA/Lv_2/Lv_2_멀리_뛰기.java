package Programmers.JAVA.Lv_2;

public class Lv_2_멀리_뛰기 {

    public long solution(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;

        if(n >= 2)
            dp[2] = 2;

        for(int i=3; i<=n; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;

        return dp[n];
    }
}
