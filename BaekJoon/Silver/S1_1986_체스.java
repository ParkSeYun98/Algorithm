package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1986_체스 {

    static int n, m;

    static int[] knightdr = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] knightdc = {1, -1, 1, -1, 2, -2, 2, -2};
    static int[] queendr = {1, 1, -1, -1, 1, -1, 0, 0};
    static int[] queendc = {1, -1, 1, -1, 0, 0, 1, -1};

    static Point[] queen, knight, pawn;

    static int[][] map;
    static boolean[][] visited;

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
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        int queenAmount = Integer.parseInt(st.nextToken());

        queen = new Point[queenAmount];

        for(int i=0; i<queenAmount; i++) {
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            queen[i] = new Point(r, c);
        }

        st = new StringTokenizer(br.readLine()," ");
        int knightAmount = Integer.parseInt(st.nextToken());

        knight = new Point[knightAmount];

        for(int i=0; i<knightAmount; i++) {
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            knight[i] = new Point(r, c);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int pawnAmount = Integer.parseInt(st.nextToken());

        pawn = new Point[pawnAmount];

        for(int i=0; i<pawnAmount; i++) {
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;

            pawn[i] = new Point(r, c);
        }

        getSafeZone();
    }

    static void getSafeZone() {
        for (Point p : pawn) {
            visited[p.r][p.c] = true;
            map[p.r][p.c] = 1;
        }

        for (Point p : knight) {
            visited[p.r][p.c] = true;
            map[p.r][p.c] = 1;

            for(int i=0; i<8; i++) {
                int nextR = p.r + knightdr[i];
                int nextC = p.c + knightdc[i];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                visited[nextR][nextC] = true;
            }
        }

        for (Point p : queen) {
            visited[p.r][p.c] = true;
            map[p.r][p.c] = 1;

            for(int i=0; i<8; i++) {
                int nowR = p.r;
                int nowC = p.c;

                while(true) {
                    int nextR = nowR + queendr[i];
                    int nextC = nowC + queendc[i];

                    if(outOfMapCheck(nextR, nextC))
                        break;

                    if(map[nextR][nextC] == 1)
                        break;

                    visited[nextR][nextC] = true;
                    nowR = nextR;
                    nowC = nextC;
                }
            }
        }

        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j])
                    cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=n || c>=m;
    }
}
