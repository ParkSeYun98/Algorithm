package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_17836_공주님을_구해라 {

    static int N, M, T;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] castle;

    static class Point {
        int r;
        int c;
        int cnt;
        boolean gram;

        public Point(int r, int c, int cnt, boolean gram) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.gram = gram;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        castle = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                castle[i][j] = Integer.parseInt(st.nextToken());
        }

        int result = BFS();

        if(result == -1)
            System.out.println("Fail");
        else
            System.out.println(result);
    }

    static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, false));

        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.cnt > T)
                return -1;

            if(now.r == N-1 && now.c == M-1)
                return now.cnt;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(now.gram) {
                    if(visited[nextR][nextC][1])
                        continue;

                    queue.offer(new Point(nextR, nextC, now.cnt+1, true));
                    visited[nextR][nextC][1] = true;
                }
                else {
                    if(gramCheck(nextR, nextC)) {
                        queue.offer(new Point(nextR, nextC, now.cnt+1, true));
                        visited[nextR][nextC][1] = true;
                    }
                    else {
                        if(visited[nextR][nextC][0])
                            continue;

                        if(wallCheck(nextR, nextC))
                            continue;

                        queue.offer(new Point(nextR, nextC, now.cnt+1, false));
                        visited[nextR][nextC][0] = true;
                    }
                }
            }
        }

        return -1;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean wallCheck(int r, int c) {
        return castle[r][c] == 1;
    }

    static boolean gramCheck(int r, int c) {
        return castle[r][c] == 2;
    }
}
