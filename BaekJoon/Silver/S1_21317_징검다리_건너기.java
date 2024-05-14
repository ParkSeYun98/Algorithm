package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_21317_징검다리_건너기 {

    static int N, K;

    static int[] small, big;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        small = new int[N];
        big = new int[N];

        dp = new int[N][2];

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());

            small[i] = Integer.parseInt(st.nextToken());
            big[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());

        DFS(0, 0, 0);

        int min = Integer.MAX_VALUE;

        if(dp[N-1][0] == 0)
            min = dp[N-1][0];
        else {
            if(dp[N-1][1] == 0)
                min = dp[N-1][0];
            else
                min = Math.min(dp[N-1][0], dp[N-1][1]);
        }

        System.out.println(min);
    }

    // dp[][0] : K 점프 X
    // dp[][1] : K 점프 O

    static void DFS(int idx, int sum, int jump) {
        if(idx >= N)
            return;

        if(dp[idx][jump] == 0)
            dp[idx][jump] = sum;
        else {
            // 현재 최소 에너지보다 큰 경우, 가지치기
            if(dp[idx][jump] < sum)
                return;

            dp[idx][jump] = sum;
        }

        // 작은 점프
        DFS(idx+1, sum+small[idx], jump);

        // 큰 점프
        DFS(idx+2, sum+big[idx], jump);

        // 매우 큰 점프 (K 점프)
        if(jump == 0)
            DFS(idx+3, sum+K, 1);
    }
}
