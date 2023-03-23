package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1600_말이_되고픈_원숭이 {
    private static int K;
    private static int W;
    private static int H;
    private static int result;

    private static int[] dxMonkey = {0, 0, 1, -1};
    private static int[] dyMonkey = {1, -1, 0, 0};
    private static int[] dxHorse = {2, 2, -2, -2, 1, 1, -1, -1};
    private static int[] dyHorse = {1, -1, 1, -1, 2, -2, 2, -2};

    private static int[][] world;
    private static boolean[][][] visited;

    private static Queue<Point> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        world = new int[H][W];

        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<W; j++)
                world[i][j] = Integer.parseInt(st.nextToken());
        }

        queue = new LinkedList<>();
        visited = new boolean[H][W][K+1];

        queue.offer(new Point(0, 0, 0, 0));
        visited[0][0][0] = true;
        result = 0;

        BFS();

        System.out.println(result);
    }

    public static void BFS() {
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.x == H-1 && now.y == W-1) {
                result = now.cnt;
                return;
            }

            for(int d=0; d<4; d++) {
                int nextX = now.x + dxMonkey[d];
                int nextY = now.y + dyMonkey[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(obstacleCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY][now.horsechance])
                    continue;

                queue.offer(new Point(nextX, nextY, now.cnt+1, now.horsechance));
                visited[nextX][nextY][now.horsechance] = true;
            }

            if(now.horsechance < K) {
                for(int d=0; d<8; d++) {
                    int nextX = now.x + dxHorse[d];
                    int nextY = now.y + dyHorse[d];

                    if(outofmapCheck(nextX, nextY))
                        continue;

                    if(obstacleCheck(nextX, nextY))
                        continue;

                    if(visited[nextX][nextY][now.horsechance+1])
                        continue;

                    queue.offer(new Point(nextX, nextY, now.cnt+1, now.horsechance + 1));
                    visited[nextX][nextY][now.horsechance + 1] = true;
                }
            }
        }

        result = -1;
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=H || y>=W;
    }

    public static boolean obstacleCheck(int x, int y) {
        return world[x][y] == 1;
    }

    public static class Point {
        int x;
        int y;
        int cnt;
        int horsechance;

        public Point(int x, int y, int cnt, int horsechance) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.horsechance = horsechance;
        }
    }
}
