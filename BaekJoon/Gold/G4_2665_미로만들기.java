/*
* Memory :
* Time :
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class G4_2665_미로만들기 {

    static int n;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] maze;

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        maze = new int[n][n];

        for(int i=0; i<n; i++) {
            String input = br.readLine();

            for(int j=0; j<n; j++)
                maze[i][j] = input.charAt(j) - '0';
        }

        BFS();
    }

    static void BFS() {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        queue.offer(new Point(0, 0, 0));

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.r == n-1 && now.c == n-1)
                min = Math.min(min, now.cnt);

            if(min < now.cnt)
                continue;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(maze[nextR][nextC] == 0)
                    queue.offer(new Point(nextR, nextC, now.cnt+1));
                else
                    queue.offer(new Point(nextR, nextC, now.cnt));

                visited[nextR][nextC] = true;
            }
        }

        if(min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=n || c>=n;
    }
}
