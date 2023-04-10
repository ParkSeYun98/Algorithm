package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N+1][4];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1; j<=3; j++)
                house[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=2; i<=N; i++) {
            house[i][1] += Math.min(house[i-1][2], house[i-1][3]);
            house[i][2] += Math.min(house[i-1][3], house[i-1][1]);
            house[i][3] += Math.min(house[i-1][1], house[i-1][2]);
        }

        System.out.println(Math.min(house[N][1], Math.min(house[N][2], house[N][3])));
    }
}
