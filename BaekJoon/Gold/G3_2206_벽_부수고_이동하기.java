package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_2206_벽_부수고_이동하기 {
    private static int N;
    private static int M;
    private static int min = Integer.MAX_VALUE;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int[][] map;
    private static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j) - '0';
        }

        BFS();

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, 0));

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.x == N-1 && now.y == M-1) {
                min = Math.min(min, now.cnt+1);
                return;
            }

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY][now.breakChance])
                    continue;

                if(wallCheck(nextX, nextY)) {
                    if(now.breakChance == 0) {
                        queue.offer(new Point(nextX, nextY, now.cnt + 1, now.breakChance + 1));
                        visited[nextX][nextY][now.breakChance+1] = true;
                    }
                }
                else {
                    queue.offer(new Point(nextX, nextY, now.cnt+1, now.breakChance));
                    visited[nextX][nextY][now.breakChance] = true;
                }
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=N || y>=M;
    }

    public static boolean wallCheck(int x, int y) {
        return map[x][y] == 1;
    }

    public static class Point {
        int x;
        int y;
        int cnt;
        int breakChance;

        public Point(int x, int y, int cnt, int breakChance) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakChance = breakChance;
        }
    }
}
