/*
* Memory : 13252 KB
* Time : 96 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class S1_1495_기타리스트 {

    static int N;
    static int S;
    static int M;
    static int max = -1;

    static int[] volumeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 곡의 개수
        S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        M = Integer.parseInt(st.nextToken()); // 최대 볼륨

        volumeArr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            volumeArr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[M+1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[S] = 0;

        for(int i=1; i<=N; i++) {
            List<Integer> changeList = new ArrayList<>();

            for(int j=0; j<=M; j++) {
                if(dp[j] == i-1) {
                    int volumeA = j - volumeArr[i-1];
                    int volumeB = j + volumeArr[i-1];

                    if(volumeA >= 0)
                        changeList.add(volumeA);

                    if(volumeB <= M)
                        changeList.add(volumeB);
                }
            }

            for (Integer change : changeList)
                dp[change] = i;
        }

        for(int i=0; i<=M; i++) {
            if(dp[i] == N)
                max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
