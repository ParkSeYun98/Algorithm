package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D4_1227_미로2 {
    private static int result;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int[][] maze;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1; tc<=10; tc++) {
            int T = Integer.parseInt(br.readLine());

            maze = new int[100][100];
            visited = new boolean[100][100];

            int startX = -1;
            int startY = -1;

            for(int i=0; i<100; i++) {
                String input = br.readLine();

                for(int j=0; j<input.length(); j++) {
                    int temp = input.charAt(j) - '0';
                    maze[i][j] = temp;

                    if(temp == 2) {
                        startX = i;
                        startY = j;
                    }
                }
            }

            result = 0;

            BFS(startX, startY);

            System.out.println("#" + T + " " + result);
        }
    }

    public static void BFS(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(maze[now.x][now.y] == 3)
                result = 1;

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(wallCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=100 || y>=100;
    }

    public static boolean wallCheck(int x, int y) {
        return maze[x][y] == 1;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
