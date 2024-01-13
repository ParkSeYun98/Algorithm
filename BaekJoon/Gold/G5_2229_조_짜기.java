package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2229_조_짜기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] students = new int[N+1];
        int[] dp = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++)
            students[i] = Integer.parseInt(st.nextToken());

        for(int i=2; i<=N; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int j=i; j>0; j--) {
                max = Math.max(max, students[j]);
                min = Math.min(min, students[j]);

                dp[i] = Math.max(dp[i], max-min+dp[j-1]);
            }
        }

        System.out.println(dp[N]);
    }
}
