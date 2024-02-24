/*
* Memory : 219024 KB
* Time : 980 ms
* */

package BaekJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5_3197_백조의_호수 {

    static int R;
    static int C;
    static Point start = null;
    static Point end = null;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] lake;
    static boolean[][] visited;

    static Queue<Point> swanQueue;
    static Queue<Point> waterQueue;

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

        lake = new char[R][C];
        visited = new boolean[R][C];
        swanQueue = new LinkedList<>();
        waterQueue = new LinkedList<>();

        boolean flag = false;

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                lake[i][j] = input.charAt(j);

                if(lake[i][j] == 'L') {
                    if(!flag) {
                        start = new Point(i, j);
                        swanQueue.offer(start);
                        visited[i][j] = true;
                        flag = true;
                    }
                    else
                        end = new Point(i, j);

                    waterQueue.offer(new Point(i, j));
                }
                else if(lake[i][j] == '.')
                    waterQueue.offer(new Point(i, j));
            }
        }

        countDate();
    }

    static void countDate() {
        int day = 0;

        while (!move()) {
            melt();
            day++;
        }

        System.out.println(day);
    }

    static boolean move() {
        List<Point> list = new ArrayList<>();

        while(!swanQueue.isEmpty()) {
            Point now = swanQueue.poll();

            if(now.r == end.r && now.c == end.c)
                return true;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(iceCheck(nextR, nextC))
                    list.add(new Point(nextR, nextC));
                else
                    swanQueue.offer(new Point(nextR, nextC));

                visited[nextR][nextC] = true;
            }
        }

        for (Point point : list)
            swanQueue.offer(point);

        return false;
    }

    static void melt() {
        int size = waterQueue.size();

        for(int i=0; i<size; i++) {
            Point now = waterQueue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(!iceCheck(nextR, nextC))
                    continue;

                waterQueue.offer(new Point(nextR, nextC));
                lake[nextR][nextC] = '.';
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean iceCheck(int r, int c) {
        return lake[r][c] == 'X';
    }
}
