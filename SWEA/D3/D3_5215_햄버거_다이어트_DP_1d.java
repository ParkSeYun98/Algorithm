package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5215_햄버거_다이어트_DP_1d {
    static int N;
    static int L;

    static int[] score;
    static int[] cal;

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            score = new int[N+1];
            cal = new int[N+1];
            dp = new int[L+1];

            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }

            Knapsack();

            System.out.println("#" + tc + " " + dp[L]);
        }
    }

    static void Knapsack() {
        for(int i=1; i<=N; i++) {
            for(int j=L; j>=cal[i]; j--)
                dp[j] = Math.max(dp[j], dp[j-cal[i]]+score[i]);
        }
    }
}
