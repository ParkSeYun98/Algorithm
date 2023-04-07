package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2146_다리_만들기 {
    static int N;
    static int min = Integer.MAX_VALUE;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int color = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    color++;
                    visited[i][j] = true;
                    initContinent(i, j, color);
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 0) {
                    connectContinent(i, j);
                }
            }
        }

        System.out.println(min);
    }

    static void initContinent(int r, int c, int color) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            map[now.r][now.c] = color;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(oceanCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    static void connectContinent(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));

        visited = new boolean[N][N];
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(map[now.r][now.c] != map[r][c] && !oceanCheck(now.r, now.c))
                min = Math.min(min, now.dist-1);

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(map[nextR][nextC] == map[r][c])
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC, now.dist+1));
                visited[nextR][nextC] = true;
            }
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }

    static boolean oceanCheck(int r, int c) {
        return map[r][c] == 0;
    }

    static class Point {
        int r;
        int c;
        int dist;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
