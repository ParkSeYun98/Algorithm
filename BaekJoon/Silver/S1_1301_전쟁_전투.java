/*
* Memory : 13524 KB
* Time : 100 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1301_전쟁_전투 {

    static int N;
    static int M;

    static int wCnt;
    static int bCnt;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] map;
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

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wCnt = 0;
        bCnt = 0;
        visited = new boolean[M][N];
        map = new char[M][N];

        for(int i=0; i<M; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j);
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j])
                    BFS(i, j, map[i][j]);
            }
        }

        System.out.println(wCnt + " " + bCnt);
    }

    static void BFS(int r, int c, char team) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));
        visited[r][c] = true;

        int teamCnt = 0;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            teamCnt++;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(!teamCheck(nextR, nextC, team))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }

        if(team == 'W')
            wCnt += (int) Math.pow(teamCnt, 2);
        else
            bCnt += (int) Math.pow(teamCnt, 2);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=M || c>=N;
    }

    static boolean teamCheck(int r, int c, char team) {
        return map[r][c] == team;
    }
}
