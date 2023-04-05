package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G1_13460_구슬_탈출_2 {
    static final int UP = 0;
    static final int RIGHT = 1;
    static final int DOWN = 2;

    static int N;
    static int M;
    static Point Rstart;
    static Point Bstart;
    static Point Goal;
    static int min;

    // 상 우 하 좌
    static final int[] dr = {-1, 0, 1, 0};
    static final int[] dc = {0, 1, 0, -1};

    static char[][] map;

    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            for (int j = 0; j < input.length(); j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'R')
                    Rstart = new Point(i, j);
                else if (map[i][j] == 'B')
                    Bstart = new Point(i, j);
                else if (map[i][j] == 'O')
                    Goal = new Point(i, j);
            }
        }

        BFS();

        System.out.println(min);
    }

    static void BFS() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(Rstart, Bstart, 1));

        visited = new boolean[N][M][N][M];
        visited[Rstart.r][Rstart.c][Bstart.r][Bstart.c] = true;

        min = -1;

        while(!queue.isEmpty()) {
            Pair now = queue.poll();

            if(now.cnt > 10) {
                min = -1;
                return;
            }

            for(int d=0; d<4; d++) {
                int RnextR = now.red.r;
                int RnextC = now.red.c;

                int BnextR = now.blue.r;
                int BnextC = now.blue.c;

                boolean redGoalFlag = false;
                boolean blueGoalFlag = false;

                while(map[RnextR+dr[d]][RnextC+dc[d]] != '#') {
                    RnextR += dr[d];
                    RnextC += dc[d];

                    if(RnextR == Goal.r && RnextC == Goal.c) {
                        redGoalFlag = true;
                        break;
                    }
                }

                while(map[BnextR+dr[d]][BnextC+dc[d]] != '#') {
                    BnextR += dr[d];
                    BnextC += dc[d];

                    if(BnextR == Goal.r && BnextC == Goal.c) {
                        blueGoalFlag = true;
                        break;
                    }
                }

                if(blueGoalFlag)
                    continue;
                else {
                    if(redGoalFlag) {
                        min = now.cnt;
                        return;
                    }
                }

                if(RnextR == BnextR && RnextC == BnextC) {
                    if(d == UP) {
                        if(now.red.r > now.blue.r)
                            RnextR -= dr[d];
                        else
                            BnextR -= dr[d];
                    }
                    else if(d == RIGHT) {
                        if(now.red.c > now.blue.c)
                            BnextC -= dc[d];
                        else
                            RnextC -= dc[d];
                    }
                    else if(d == DOWN) {
                        if(now.red.r > now.blue.r)
                            BnextR -= dr[d];
                        else
                            RnextR -= dr[d];
                    }
                    else {
                        if(now.red.c > now.blue.c)
                            RnextC -= dc[d];
                        else
                            BnextC -= dc[d];
                    }
                }

                if(!visited[RnextR][RnextC][BnextR][BnextC]) {
                    visited[RnextR][RnextC][BnextR][BnextC] = true;
                    queue.offer(new Pair(new Point(RnextR, RnextC), new Point(BnextR, BnextC), now.cnt+1));
                }
            }
        }

        min = -1;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Pair {
        Point red;
        Point blue;
        int cnt;

        public Pair(Point red, Point blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }
    }
}