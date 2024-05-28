package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G3_16954_움직이는_미로_탈출 {

    static boolean check;

    static int[] dr = {0, 0, 1, -1, 1, 1, -1, -1, 0};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1, 0};

    static char[][] chess;

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

        check = false;
        chess = new char[8][8];

        for(int i=0; i<8; i++)
            chess[i] = br.readLine().toCharArray();

        BFS();

        if(check)
            System.out.println(1);
        else
            System.out.println(0);
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(7, 0));

        boolean[][] visited;

        while(!queue.isEmpty()) {
            int size = queue.size();

            visited = new boolean[8][8];

            for(int i=0; i<size; i++) {
                Point now = queue.poll();

                if(chess[now.r][now.c] == '#')
                    continue;

                if(now.r == 0 && now.c == 7) {
                    check = true;
                    return;
                }

                for(int d=0; d<9; d++) {
                    int nextR = now.r + dr[d];
                    int nextC = now.c + dc[d];

                    if(outOfMapCheck(nextR, nextC))
                        continue;

                    if(wallCheck(nextR, nextC))
                        continue;

                    if(visited[nextR][nextC])
                        continue;

                    queue.offer(new Point(nextR, nextC));
                    visited[nextR][nextC] = true;
                }
            }

            wallDown();
        }
    }

    static void wallDown() {
        for(int i=7; i>=0; i--) {
            for(int j=0; j<8; j++) {
                if(chess[i][j] == '#') {
                    chess[i][j] = '.';

                    if(i != 7)
                        chess[i+1][j] = '#';
                }
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=8 || c>=8;
    }

    static boolean wallCheck(int r, int c) {
        return chess[r][c] == '#';
    }
}
