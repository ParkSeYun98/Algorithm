/*
* Memory : 15388 KB
* Time : 112 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_1194_달이_차오른다_가자 {

    static int N;
    static int M;
    static Point start;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static char[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                char temp = input.charAt(j);
                maze[i][j] = temp;

                if(temp == '0')
                    start = new Point(i, j, 0, 0);
            }
        }

        findRoute();
    }

    static void findRoute() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][][] visited = new boolean[N][M][64];
        visited[start.r][start.c][0] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(maze[now.r][now.c] == '1') {
                System.out.println(now.cnt);
                return;
            }

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC][now.key])
                    continue;

                if(maze[nextR][nextC] >= 'a' && maze[nextR][nextC] <= 'f') {
                    int key = now.key | (1 << (maze[nextR][nextC]-'a'));

                    queue.offer(new Point(nextR, nextC, now.cnt+1, key));
                    visited[nextR][nextC][key] = true;
                }
                else if(maze[nextR][nextC] >= 'A' && maze[nextR][nextC] <= 'F') {
                    if((now.key & (1 << (maze[nextR][nextC]-'A'))) != 0) {
                        queue.offer(new Point(nextR, nextC, now.cnt+1, now.key));
                        visited[nextR][nextC][now.key] = true;
                    }
                }
                else {
                    queue.offer(new Point(nextR, nextC, now.cnt+1, now.key));
                    visited[nextR][nextC][now.key] = true;
                }
            }
        }

        System.out.println(-1);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean wallCheck(int r, int c) {
        return maze[r][c] == '#';
    }

    static class Point {
        int r;
        int c;
        int cnt;
        int key;

        public Point(int r, int c, int cnt, int key) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.key = key;
        }
    }
}
