package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_11722_가장_긴_감소하는_부분_수열 {

    static int N;

    static int[] A, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, 1);

        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(A[i] < A[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int ans = -1;

        for (int i : dp)
            ans = Math.max(ans, i);

        System.out.println(ans);
    }
}
