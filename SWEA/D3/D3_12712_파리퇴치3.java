/*
* Memory : 19540 KB
* Time : 122 ms
* */
package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_12712_파리퇴치3 {

    static int N;
    static int M;
    static int max;

    static int[] drPlus = {1, -1, 0, 0};
    static int[] dcPlus = {0, 0, 1, -1};

    static int[] drCross = {1, 1, -1, -1};
    static int[] dcCross = {1, -1, 1, -1};

    static int[][] area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            max = Integer.MIN_VALUE;
            area = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++)
                    area[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    PlusDFS(new Point(i, j));
                    CrossDFS(new Point(i, j));
                }
            }

            System.out.println("#" + tc + " " + max);
        }
    }

    static void PlusDFS(Point start) {
        int cnt = area[start.r][start.c];

        for(int d=0; d<4; d++) {
            int nextR = start.r;
            int nextC = start.c;

            for(int i=0; i<M-1; i++) {
                nextR += drPlus[d];
                nextC += dcPlus[d];

                if(outOfMapCheck(nextR, nextC))
                    break;

                cnt += area[nextR][nextC];
            }
        }

        max = Math.max(max, cnt);
    }

    static void CrossDFS(Point start) {
        int cnt = area[start.r][start.c];

        for(int d=0; d<4; d++) {
            int nextR = start.r;
            int nextC = start.c;

            for(int i=0; i<M-1; i++) {
                nextR += drCross[d];
                nextC += dcCross[d];

                if(outOfMapCheck(nextR, nextC))
                    break;

                cnt += area[nextR][nextC];
            }
        }

        max = Math.max(max, cnt);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
