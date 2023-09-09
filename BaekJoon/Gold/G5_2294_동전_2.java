package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2294_동전_2 {

    private static int n;
    private static int k;

    private static int[] value;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        value = new int[n+1];
        dp = new int[k+1];

        Arrays.fill(dp, 999999);
        dp[0] = 0;

        for(int i=0; i<n; i++)
            value[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {
            for(int j=value[i]; j<=k; j++) {
                dp[j] = Math.min(dp[j], dp[j-value[i]] + 1);
            }
        }

        if(dp[k] == 999999)
            System.out.println(-1);
        else
            System.out.println(dp[k]);
    }
}
