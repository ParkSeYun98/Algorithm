package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_16956_늑대와_양 {

    static int R, C;
    static boolean flag;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] field;
    static boolean[][] visited;

    static Queue<Point> queue;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        flag = true;
        field = new char[R][C];
        visited = new boolean[R][C];
        queue = new LinkedList<>();

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                char now = input.charAt(j);
                field[i][j] = now;

                if(now == 'W') {
                    queue.offer(new Point(i, j));
                }
            }
        }

        BFS();

        if(!flag)
            System.out.println(0);
        else {
            System.out.println(1);

            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++)
                    System.out.print(field[i][j]);

                System.out.println();
            }
        }
    }

    static void BFS() {
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(field[nextR][nextC] == '.')
                    field[nextR][nextC] = 'D';
                else if(field[nextR][nextC] == 'S') {
                    flag = false;
                    return;
                }
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }
}
