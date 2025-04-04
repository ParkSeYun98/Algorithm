package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_9625_BABBA {

    static int K;

    static class Code {
        int allCnt;
        int aCnt;
        int bCnt;

        public Code (int allCnt, int aCnt, int bCnt) {
            this.allCnt = allCnt;
            this.aCnt = aCnt;
            this.bCnt = bCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Code[] dp = new Code[K+1];

        dp[0] = new Code(1, 1, 0);

        for(int i=1; i<=K; i++) {
            Code prev = dp[i-1];
            Code now = new Code(prev.allCnt + prev.bCnt, prev.bCnt, prev.allCnt);

            dp[i] = now;
        }

        System.out.println(dp[K].aCnt + " " + dp[K].bCnt);
    }
}
