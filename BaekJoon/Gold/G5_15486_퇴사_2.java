package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_15486_퇴사_2 {

    static int N;

    static int[] dp, T, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N+2];
        T = new int[N+2];
        P = new int[N+2];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int nowMax = -1;

        for(int i=1; i<dp.length; i++) {
            if(nowMax < dp[i])
                nowMax = dp[i];

            if(i + T[i] >= dp.length)
                continue;

            dp[i+T[i]] = Math.max(dp[i+T[i]], nowMax + P[i]);
        }

        System.out.println(dp[N+1]);
    }
}
