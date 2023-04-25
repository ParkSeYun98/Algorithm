package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_16933_벽_부수고_이동하기_3 {
    static int N;
    static int M;
    static int K;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j) - '0';
        }

        BFS();
    }

    static void BFS() {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(0, 0, 1, 0, 0));

        boolean[][][][] visited = new boolean[N][M][K+1][2];
        visited[0][0][0][0] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.r == N-1 && now.c == M-1) {
                System.out.println(now.cnt);
                return;
            }

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC)) {
                    if(now.crashCnt < K && now.day == 0 && !visited[nextR][nextC][now.crashCnt+1][now.day+1]) {
                        queue.offer(new Point(nextR, nextC, now.cnt+1, now.crashCnt+1, now.day+1));
                        visited[nextR][nextC][now.crashCnt+1][now.day+1] = true;
                    }
                    else if(now.crashCnt < K && now.day == 1 && !visited[now.r][now.c][now.crashCnt][now.day-1]) {
                        queue.offer(new Point(now.r, now.c, now.cnt+1, now.crashCnt, now.day-1));
                        visited[now.r][now.c][now.crashCnt][now.day-1] = true;
                    }
                }
                else {
                    if(now.day == 0 && !visited[nextR][nextC][now.crashCnt][now.day+1]) {
                        queue.offer(new Point(nextR, nextC, now.cnt+1, now.crashCnt, now.day+1));
                        visited[nextR][nextC][now.crashCnt][now.day+1] = true;
                    }
                    else if(now.day == 1 && !visited[nextR][nextC][now.crashCnt][now.day-1]) {
                        queue.offer(new Point(nextR, nextC, now.cnt+1, now.crashCnt, now.day-1));
                        visited[nextR][nextC][now.crashCnt][now.day-1] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean wallCheck(int r, int c) {
        return map[r][c] == 1;
    }

    static class Point {
        int r;
        int c;
        int cnt;
        int crashCnt;
        int day;

        public Point(int r, int c, int cnt, int crashCnt, int day) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.crashCnt = crashCnt;
            this.day = day;
        }
    }
}
