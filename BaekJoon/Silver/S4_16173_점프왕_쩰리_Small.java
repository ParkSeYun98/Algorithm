package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_16173_점프왕_쩰리_Small {

    static int N;

    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    static int[][] map;
    static boolean[][] visited;

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

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[0][0] = true;
        DFS(new Point(0, 0));

        System.out.println("Hing");
    }

    static void DFS(Point start) {
        int now = map[start.r][start.c];

        if(now == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for(int d=0; d<2; d++) {
            int nextR = start.r + (dr[d]*now);
            int nextC = start.c + (dc[d]*now);

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(visited[nextR][nextC])
                continue;

            visited[nextR][nextC] = true;
            DFS(new Point(nextR, nextC));
            visited[nextR][nextC] = false;
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r>=N || c>=N || r<0 || c<0;
    }
}
