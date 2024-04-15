package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_17086_아기_상어_2 {

    static int N, M, max;

    static int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    static int[][] ocean;

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        ocean = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                ocean[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(ocean[i][j] == 1)
                    continue;

                BFS(new Point(i, j, 0));
            }
        }

        System.out.println(max);
    }

    static void BFS(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] visited = new boolean[N][M];
        visited[start.r][start.c] = true;

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(ocean[now.r][now.c] == 1)
                min = Math.min(min, now.cnt);

            for(int d=0; d<8; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC, now.cnt+1));
                visited[nextR][nextC] = true;
            }
        }

        max = Math.max(max, min);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }
}
