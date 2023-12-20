/*
Memory : 300956 KB
Time : 924 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_11967_불켜기 {

    private static int N;
    private static int M;

    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};

    private static List<Point>[][] barn;
    private static boolean[][] light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barn = new ArrayList[N+1][N+1];
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=N; j++)
                barn[i][j] = new ArrayList<>();
        }

        light = new boolean[N+1][N+1];
        light[1][1] = true;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            barn[x][y].add(new Point(a, b));
        }

        System.out.println(BFS() + 1);
    }

    public static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1));

        boolean[][] visited = new boolean[N+1][N+1];

        int cnt = 0;
        boolean switchFlag = false;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(!light[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }

            for (Point point : barn[now.r][now.c]) {
                if(!light[point.r][point.c]) {
                    light[point.r][point.c] = true;
                    switchFlag = true;
                    cnt++;
                }
            }
        }

        if(switchFlag)
            return cnt + BFS();
        else
            return cnt;
    }

    public static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>N || c>N;
    }

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
