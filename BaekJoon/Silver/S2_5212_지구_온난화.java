package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_5212_지구_온난화 {

    static int R, C;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] ocean;

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

        ocean = new char[R][C];
        queue = new LinkedList<>();

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                ocean[i][j] = input.charAt(j);

                if(ocean[i][j] == 'X')
                    queue.offer(new Point(i, j));
            }
        }

        BFS();

        findNewMap();
    }

    static void BFS() {
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            int cnt = 0;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC=  now.c + dc[d];

                if(outOfMapCheck(nextR, nextC)) {
                    cnt++;
                    continue;
                }

                if(!oceanCheck(nextR, nextC))
                    continue;

                cnt++;
            }

            if(cnt >= 3)
                ocean[now.r][now.c] = 'O';
        }
    }

    static void findNewMap() {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(ocean[i][j] == 'X') {
                    minR = Math.min(minR, i);
                    minC = Math.min(minC, j);
                    maxR = Math.max(maxR, i);
                    maxC = Math.max(maxC, j);
                }
            }
        }

        print(minR, minC, maxR, maxC);
    }

    static void print(int minR, int minC, int maxR, int maxC) {
        for(int i=minR; i<=maxR; i++) {
            for(int j=minC; j<=maxC; j++) {
                if(ocean[i][j] == 'O')
                    System.out.print('.');
                else
                    System.out.print(ocean[i][j]);
            }

            System.out.println();
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean oceanCheck(int r, int c) {
        return ocean[r][c] == '.';
    }
}
