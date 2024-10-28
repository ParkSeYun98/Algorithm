package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_14697_방_배정하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if(A==1 || B==1 || C==1 || N%A==0 || N%B==0 || N%C==0) {
            System.out.println(1);
            return;
        }

        boolean[] dp = new boolean[301];

        dp[A] = true;
        dp[B] = true;
        dp[C] = true;

        for(int i=A; i<=N; i++) {
            if(i-A>=0 && dp[i-A]) {
                dp[i] = true;
                continue;
            }

            if(i-B>=0 && dp[i-B]) {
                dp[i] = true;
                continue;
            }

            if(i-C>=0 && dp[i-C])
                dp[i] = true;
        }

        if (dp[N])
            System.out.println(1);
        else
            System.out.println(0);
    }
}
