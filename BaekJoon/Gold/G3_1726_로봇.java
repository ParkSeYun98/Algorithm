package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1726_로봇 {
    private static int M;
    private static int N;
    private static int min = Integer.MAX_VALUE;

    private static int startX;
    private static int startY;
    private static int startDir;

    private static int endX;
    private static int endY;
    private static int endDir;

    // 동 서 남 북
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N][5];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;
        startDir = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        endX = Integer.parseInt(st.nextToken()) - 1;
        endY = Integer.parseInt(st.nextToken()) - 1;
        endDir = Integer.parseInt(st.nextToken());

        BFS();

        System.out.println(min);
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, startDir, 0));
        visited[startX][startY][startDir] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.x == endX && now.y == endY && now.dir == endDir) {
                min = Math.min(min, now.cnt);
                return;
            }

            for(int i=1; i<=3; i++) {
                int nextX = now.x + dx[now.dir-1] * i;
                int nextY = now.y + dy[now.dir-1] * i;

                if(outofmapCheck(nextX, nextY))
                    break;

                if(orbitCheck(nextX, nextY))
                    break;

                if(visited[nextX][nextY][now.dir])
                    continue;

                queue.offer(new Point(nextX, nextY, now.dir, now.cnt+1));
                visited[nextX][nextY][now.dir] = true;
            }

            int left = 0;
            int right = 0;

            // 동
            if(now.dir == 1) {
                left = 4;
                right = 3;
            }
            // 서
            else if(now.dir == 2) {
                left = 3;
                right = 4;
            }
            // 남
            else if(now.dir == 3 ) {
                left = 1;
                right = 2;
            }
            // 북
            else {
                left = 2;
                right = 1;
            }

            if(!visited[now.x][now.y][left]) {
                queue.offer(new Point(now.x, now.y, left, now.cnt+1));
                visited[now.x][now.y][left] = true;
            }

            if(!visited[now.x][now.y][right]) {
                queue.offer(new Point(now.x, now.y, right, now.cnt+1));
                visited[now.x][now.y][right] = true;
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=M || y>=N;
    }

    public static boolean orbitCheck(int x, int y) {
        return map[x][y] == 1;
    }

    public static class Point {
        int x;
        int y;
        int dir;
        int cnt;

        public Point(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
