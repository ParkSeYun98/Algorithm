package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_1926_그림 {
    private static int n;
    private static int m;
    private static int count = 0;
    private static int max = Integer.MIN_VALUE;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static int[][] picture;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        picture = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<m; j++)
                picture[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && picture[i][j] == 1) {
                    BFS(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        if(max == Integer.MIN_VALUE)
            System.out.println(0);
        else
            System.out.println(max);
    }

    public static void BFS(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;
        int cnt = 1;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int d=0; d<4; d++) {
                int nextX = nowX + dx[d];
                int nextY = nowY + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(!colorCheck(nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
                cnt++;
            }
        }

        max = Math.max(max, cnt);
    }

    public static boolean colorCheck(int x, int y) {
        return picture[x][y] == 1;
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=n || y>=m;
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
