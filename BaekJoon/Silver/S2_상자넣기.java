package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_상자넣기 {
    private static int N;
    private static int max = Integer.MIN_VALUE;

    private static int[] arr;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.fill(dp, 1);

        putboxinbox();

        getmaxBox();
    }

    public static void putboxinbox() {
        for(int i=2; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }

    public static void getmaxBox() {
        for(int i=1; i<=N; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}
