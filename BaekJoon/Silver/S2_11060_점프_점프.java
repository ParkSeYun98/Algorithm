package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_11060_점프_점프 {

    static int N;

    static int[] maze;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        maze = new int[N];
        dp = new long[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            maze[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=0; i<N; i++) {
            for(int j=1; j<=maze[i]; j++) {
                if(i+j >= N)
                    continue;

                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        if(dp[N-1] == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(dp[N-1]);
    }
}
