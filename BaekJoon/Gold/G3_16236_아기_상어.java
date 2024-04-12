package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_16236_아기_상어 {

    static int N, sharkSize, minDist, eatCnt, moveCnt;
    static Point sharkP, minP;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static int[][] ocean, dist;

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

        N = Integer.parseInt(br.readLine());

        sharkSize = 2;
        eatCnt = 0;
        moveCnt = 0;
        ocean = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());

                if(ocean[i][j] == 9) {
                    sharkP = new Point(i, j);
                    ocean[i][j] = 0;
                }
            }
        }

        timeGoesOn();
    }

    static void timeGoesOn() {
        while(true) {
            minDist = Integer.MAX_VALUE;
            minP = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
            dist = new int[N][N];

            BFS();

            if(minP.r != Integer.MAX_VALUE && minP.c != Integer.MAX_VALUE) {
                sharkP = new Point(minP.r, minP.c);
                ocean[minP.r][minP.c] = 0;
                eatCnt++;
                moveCnt += dist[minP.r][minP.c];

                if(eatCnt == sharkSize) {
                    sharkSize++;
                    eatCnt = 0;
                }
            }
            else
                break;
        }

        System.out.println(moveCnt);
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(sharkP);

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(!moveCheck(nextR, nextC))
                    continue;

                if(dist[nextR][nextC] != 0)
                    continue;

                dist[nextR][nextC] = dist[now.r][now.c] + 1;
                queue.offer(new Point(nextR, nextC));

                if(eatCheck(nextR, nextC)) {
                    if(minDist > dist[nextR][nextC]) {
                        minDist = dist[nextR][nextC];
                        minP = new Point(nextR, nextC);
                    }
                    else if(minDist == dist[nextR][nextC]) {
                        if(minP.r > nextR)
                            minP = new Point(nextR, nextC);
                        else if(minP.r == nextR) {
                            if(minP.c > nextC)
                                minP = new Point(nextR, nextC);
                        }
                    }
                }
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static boolean moveCheck(int r, int c) {
        return ocean[r][c] <= sharkSize;
    }

    static boolean eatCheck(int r, int c) {
        return ocean[r][c] < sharkSize && ocean[r][c] > 0;
    }
}
