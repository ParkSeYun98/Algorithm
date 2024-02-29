/*
* Memory : 38952 KB
* Time : 384 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_16724_피리_부는_사나이 {

    static int N, M, cnt;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static char[][] map;
    static boolean[][] visited, cycle;

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

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j);
        }

        cnt = 0;
        visited = new boolean[N][M];
        cycle = new boolean[N][M];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j])
                    getSafeZone(new Point(i, j));
            }
        }

        System.out.println(cnt);
    }

    static void getSafeZone(Point now) {
        visited[now.r][now.c] = true;

        int nextR = now.r + dr[changeDirection(now)];
        int nextC = now.c + dc[changeDirection(now)];

        if(outOfMapCheck(nextR, nextC))
            return;

        if(!visited[nextR][nextC])
            getSafeZone(new Point(nextR, nextC));
        else {
            if(!cycle[nextR][nextC])
                cnt++;
        }

        cycle[now.r][now.c] = true;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static int changeDirection(Point now) {
        char dir = map[now.r][now.c];

        if(dir == 'U')
            return 0;
        else if(dir == 'D')
            return 1;
        else if(dir == 'L')
            return 2;
        else
            return 3;
    }
}
