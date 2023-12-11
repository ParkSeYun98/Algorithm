package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S1_1_2_3_더하기_2 {

    private static int n;
    private static int k;
    private static int cnt = 0;
    private static boolean flag = false;

    private static List<String>[] dp = new ArrayList[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<dp.length; i++)
            dp[i] = new ArrayList<>();

        dp[1].add("1");

        dp[2].add("1+1");
        dp[2].add("2");

        dp[3].add("1+1+1");
        dp[3].add("1+2");
        dp[3].add("2+1");
        dp[3].add("3");

        for(int i=4; i<12; i++) {
            for(int j=1; j<=3; j++) {
                for(int k=0; k<dp[i-j].size(); k++)
                    dp[i].add(dp[i-j].get(k) + "+" + j);
            }
        }

        if(dp[n].size() < k)
            System.out.println(-1);
        else {
            Collections.sort(dp[n]);
            System.out.println(dp[n].get(k-1));
        }
    }
}
