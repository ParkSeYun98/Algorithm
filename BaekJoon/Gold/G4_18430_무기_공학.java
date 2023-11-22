/*
* Memory : 110248KB
* Time: 432ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_18430_무기_공학 {

    private static int N;
    private static int M;
    private static int max = 0;

    private static final int[][][] boomerang = {{{0, 1}, {-1, 0}}, {{1, 0}, {0, 1}}, {{0, -1}, {1, 0}}, {{-1, 0}, {0, -1}}};

    private static int[][] treeIngredient;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        treeIngredient = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                treeIngredient[i][j] = Integer.parseInt(st.nextToken());
        }

        makeBoomerang(0, 0);

        System.out.println(max);
    }

    public static void makeBoomerang(int depth, int intensity) {
        if(depth == N * M) {
            max = Math.max(max, intensity);
            return;
        }

        int nowR = depth / M;
        int nowC = depth % M;

        if(!visited[nowR][nowC]) {
            for(int d=0; d<4; d++) {
                Direction d1 = new Direction(nowR + boomerang[d][0][0], nowC + boomerang[d][0][1]);
                Direction d2 = new Direction(nowR + boomerang[d][1][0], nowC + boomerang[d][1][1]);

                if(outOfMapCheck(d1, d2))
                    continue;

                if(visited[d1.r][d1.c] || visited[d2.r][d2.c])
                    continue;

                visited[nowR][nowC] = true;
                visited[d1.r][d1.c] = true;
                visited[d2.r][d2.c] = true;

                int partIntensity = 2 * treeIngredient[nowR][nowC] + treeIngredient[d1.r][d1.c] + treeIngredient[d2.r][d2.c];
                makeBoomerang(depth + 1, intensity + partIntensity);

                visited[nowR][nowC] = false;
                visited[d1.r][d1.c] = false;
                visited[d2.r][d2.c] = false;
            }
        }

        makeBoomerang(depth + 1, intensity);
    }

    public static boolean outOfMapCheck(Direction d1, Direction d2) {
        return d1.r < 0 || d1.c < 0 || d1.r >= N || d1.c >= M || d2.r < 0 || d2.c < 0 || d2.r >= N || d2.c >= M;
    }

    public static class Direction {
        int r;
        int c;

        public Direction(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
