/*
* Memory : 85760 KB
* Time : 2276 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_14940_쉬운_최단거리 {

    static int n, m;
    static Point startP;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] map, result;

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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];

        for(int i=0; i<n; i++)
            Arrays.fill(result[i], -1);

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    startP = new Point(i, j, 0);
                    result[i][j] = 0;
                }
                else if(map[i][j] == 0)
                    result[i][j] = 0;
            }
        }

        BFS(startP);

        print();
    }

    static void BFS(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] visited = new boolean[n][m];
        visited[start.r][start.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(zeroCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC, now.cnt+1));
                visited[nextR][nextC] = true;
                result[nextR][nextC] = now.cnt+1;
            }
        }
    }

    static void print() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++)
                System.out.print(result[i][j] + " ");

            System.out.println();
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=n || c>=m;
    }

    static boolean zeroCheck(int r, int c) {
        return map[r][c] == 0;
    }
}
