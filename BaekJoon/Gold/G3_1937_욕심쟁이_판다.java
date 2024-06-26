package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_1937_욕심쟁이_판다 {

    static int n;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] forest, dp;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        forest = new int[n][n];
        dp = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<n; j++)
                forest[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++)
            Arrays.fill(dp[i], 1);

        int result = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                result = Math.max(result, DFS(new Point(i, j)));
        }

        System.out.println(result);
    }

    static int DFS(Point start) {
        if(dp[start.r][start.c] != 1)
            return dp[start.r][start.c];

        for(int d=0; d<4; d++) {
            int nextR = start.r + dr[d];
            int nextC = start.c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(forest[start.r][start.c] < forest[nextR][nextC]) {
                dp[start.r][start.c] = Math.max(dp[start.r][start.c], DFS(new Point(nextR, nextC)) + 1);
                DFS(new Point(nextR, nextC));
            }
        }

        return dp[start.r][start.c];
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=n || c>=n;
    }
}
