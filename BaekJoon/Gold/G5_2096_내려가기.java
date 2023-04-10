package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] stage = new int[N+1][4];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1; j<=3; j++)
                stage[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] copyStage = new int[N+1][4];

        for(int i=0; i<N+1; i++)
            copyStage[i] = stage[i].clone();

        for(int i=2; i<=N; i++) {
            stage[i][1] += Math.max(stage[i-1][1], stage[i-1][2]);
            stage[i][2] += Math.max(stage[i-1][1], Math.max(stage[i-1][2], stage[i-1][3]));
            stage[i][3] += Math.max(stage[i-1][2], stage[i-1][3]);

            copyStage[i][1] += Math.min(copyStage[i-1][1], copyStage[i-1][2]);
            copyStage[i][2] += Math.min(copyStage[i-1][1], Math.min(copyStage[i-1][2], copyStage[i-1][3]));
            copyStage[i][3] += Math.min(copyStage[i-1][2], copyStage[i-1][3]);
        }

        int max = Math.max(stage[N][1], Math.max(stage[N][2], stage[N][3]));
        int min = Math.min(copyStage[N][1], Math.min(copyStage[N][2], copyStage[N][3]));

        System.out.println(max + " " + min);
    }
}
