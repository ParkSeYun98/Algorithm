/*
* Memory : 16252 KB
* Time : 160 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_14620_꽃길 {

    static int N, minPrice;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] soil;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        minPrice = Integer.MAX_VALUE;
        soil = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine() ," ");

            for(int j=0; j<N; j++)
                soil[i][j] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);

        System.out.println(minPrice);
    }

    static void combination(int depth, int start) {
        if(depth == 3) {
            rental();
            return;
        }

        for(int i=start; i<N*N; i++) {
            int nowR = i/N;
            int nowC = i%N;

            if(!visitCheck(nowR, nowC)) {
                visit(nowR, nowC, true);
                combination(depth+1, i);
                visit(nowR, nowC, false);
            }
        }
    }

    static boolean visitCheck(int r, int c) {
        if(visited[r][c])
            return true;

        for (int d=0; d<4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                return true;

            if(visited[nextR][nextC])
                return true;
        }

        return false;
    }

    static void visit(int r, int c, boolean visit) {
        for(int d=0; d<4; d++) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];

            visited[nextR][nextC] = visit;
        }

        visited[r][c] = visit;
    }

    static void rental() {
        int price = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(visited[i][j])
                    price += soil[i][j];
            }
        }

        minPrice = Math.min(minPrice, price);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }
}
