/*
* Memory : 39892 KB
* Time : 320 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_1520_내리막_길 {

    static int M;
    static int N;
    static int cnt;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        cnt = 0;
        map = new int[M][N];
        dp = new int[M][N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(new Point(0, 0)));
    }

    static int DFS(Point nowP) {
        if(nowP.r == M-1 && nowP.c == N-1) {
            return 1;
        }

        if(dp[nowP.r][nowP.c] != -1)
            return dp[nowP.r][nowP.c];

        dp[nowP.r][nowP.c]++;

        for(int d=0; d<4; d++) {
            int nextR = nowP.r + dr[d];
            int nextC = nowP.c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(!downCheck(nextR, nextC, nowP))
                continue;

            dp[nowP.r][nowP.c] += DFS(new Point(nextR, nextC));
        }

        return dp[nowP.r][nowP.c];
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=M || c>=N;
    }

    static boolean downCheck(int r, int c, Point beforeP) {
        return map[r][c] < map[beforeP.r][beforeP.c];
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
