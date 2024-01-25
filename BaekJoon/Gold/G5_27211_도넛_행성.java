/*
* Memory : 120480 KB
* Time : 528 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_27211_도넛_행성 {

    static int N;
    static int M;
    static int cnt;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static int[][] planet;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = 0;
        planet = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                planet[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(planet[i][j] == 0 && !visited[i][j]) {
                    BFS(new Point(i, j));
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void BFS(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.r][start.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(nextR<0)
                    nextR = N-1;
                else if(nextR>=N)
                    nextR = 0;

                if(nextC<0)
                    nextC = M-1;
                else if(nextC>=M)
                    nextC = 0;

                if(forestCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    static boolean forestCheck(int r, int c) {
        return planet[r][c] == 1;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
