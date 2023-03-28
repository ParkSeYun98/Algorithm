package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_7733_치즈_도둑 {
    private static int N;

    private static final int[] dx = {0, 0, 1, -1};
    private static final int[] dy = {1, -1, 0, 0};

    private static int[][] Freezer;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            Freezer = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < N; j++)
                    Freezer[i][j] = Integer.parseInt(st.nextToken());
            }


            int max = Integer.MIN_VALUE;

            for(int day=0; day<=100; day++) {
                visited = new boolean[N][N];
                int cnt = 0;

                for(int i=0; i<N; i++) {
                    for(int j=0; j<N; j++) {
                        if(Freezer[i][j] > day && !visited[i][j]) {
                            BFS(day, i, j);
                            cnt++;
                        }
                    }
                }

                max = Math.max(max, cnt);

                if(cnt == 0)
                    break;
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    public static void BFS(int day, int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextX = now.x + dx[d];
                int nextY = now.y + dy[d];

                if(outofmapCheck(nextX, nextY))
                    continue;

                if(alreadyEatcheck(day, nextX, nextY))
                    continue;

                if(visited[nextX][nextY])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }

    public static boolean outofmapCheck(int x, int y) {
        return x<0 || y<0 || x>=N || y>=N;
    }

    public static boolean alreadyEatcheck(int day, int x, int y) {
        return Freezer[x][y] <= day;
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
