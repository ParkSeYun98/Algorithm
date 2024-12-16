package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S5_19947_투자의_귀재_배주형 {

    static int H, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int[] dp = new int[Y+1];
        dp[0] = H;

        for(int i=1; i<=Y; i++) {
            if(i>=5)
                dp[i] = (int) Math.max(dp[i], dp[i-5]*1.35);

            if(i>=3)
                dp[i] = (int) Math.max(dp[i], dp[i-3]*1.2);

            dp[i] = (int) Math.max(dp[i], dp[i-1]*1.05);
        }

        System.out.println(dp[Y]);
    }
}
