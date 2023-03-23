package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2146_다리_만들기 {
    private static int N;
    private static int min = Integer.MAX_VALUE;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int[][] map;
    private static boolean[][] visited;

    private static Queue<Point> queue;

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

        // 대륙 구분
        queue = new LinkedList<>();
        int continentId = 2;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new Point(i, j));
                    map[i][j] = continentId;
                    distinction(continentId++);
                }
            }
        }

        // 다리 놓기
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != 0) {
                    visited = new boolean[N][N];
                    visited[i][j] = true;
                    queue.offer(new Point(i, j, 0));
                    buildBridge(map[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    public static void distinction(int continentId) {
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(oceanCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                map[nextX][nextY] = continentId;
            }
        }
    }

    public static void buildBridge(int startcontinentid) {
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                if(map[nextX][nextY] == startcontinentid)
                    continue;

                if(!oceanCheck(nextX, nextY) && map[nextX][nextY] != startcontinentid)
                    min = Math.min(min, now.cnt);

                queue.offer(new Point(nextX, nextY, now.cnt+1));
                visited[nextX][nextY] = true;
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }

    public static boolean oceanCheck(int x, int y) {
        return map[x][y] == 0;
    }

    public static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
