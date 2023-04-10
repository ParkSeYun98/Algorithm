package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_SW_역량_테스트_1952_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            int[] charge = new int[5];
            int[] plan = new int[13];
            int[] dp = new int[13];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=4; i++)
                charge[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=1; i<=12; i++)
                plan[i] = Integer.parseInt(st.nextToken());

            for(int i=1; i<=12; i++) {
                if(plan[i] == 0)
                    dp[i] = dp[i-1];
                else {
                    int min = Integer.MAX_VALUE;

                    min = Math.min(min, charge[4]);
                    if(i >= 3)
                        min = Math.min(min, dp[i-3] + charge[3]);
                    min = Math.min(min, dp[i-1] + charge[2]);
                    min = Math.min(min, dp[i-1] + charge[1]*plan[i]);
                    dp[i] = min;
                }
            }

            System.out.println("#" + tc + " " + dp[12]);

        }
    }
}
