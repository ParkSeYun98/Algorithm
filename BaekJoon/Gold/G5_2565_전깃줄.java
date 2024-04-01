package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G5_2565_전깃줄 {

    static int N;

    static int[] dp;

    static int[][] wire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        wire = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Arrays.fill(dp, 1);

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<i; j++) {
                if(wire[i][1] > wire[j][1])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = 0;

        for(int i=0; i<N; i++)
            max = Math.max(max, dp[i]);

        System.out.println(N - max);
    }
}
