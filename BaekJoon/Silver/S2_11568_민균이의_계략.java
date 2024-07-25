package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_11568_민균이의_계략 {

    static int N;

    static int[] cardArr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cardArr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            cardArr[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, 1);

        for(int i=1; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(cardArr[j] < cardArr[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = -1;

        for(int i=0; i<dp.length; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}
