/*
* Memory : 11616 KB
* Time : 88ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2293_동전_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] price = new int[n];
        int[] dp = new int[k + 1];

        for(int i = 0; i< n; i++)
            price[i] = Integer.parseInt(br.readLine());

        dp[0] = 1;

        for (int value : price) {
            for (int j = value; j <= k; j++)
                dp[j] += dp[j - value];
        }

        System.out.println(dp[k]);
    }
}
