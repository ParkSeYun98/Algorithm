/*
* Memory : 25176 KB
* Time : 136 ms
* */

package SWEA.SW_Test_샘플문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SW_Test_샘플문제_1767_프로세서_연결하기 {

    static int N;
    static int min;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[] visited;

    static int[][] maxinos;

    static List<Point> coreList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            min = Integer.MAX_VALUE;
            maxinos = new int[N][N];
            coreList = new ArrayList<>();

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    maxinos[i][j] = temp;

                    if(temp==1 && i!=0 && j!=0 && i!=N-1 && j!=N-1)
                        coreList.add(new Point(i, j));
                }
            }

            visited = new boolean[coreList.size()];

            for(int i=coreList.size(); i>=0; i--) {
                combination(0, 0, i);

                if(min != Integer.MAX_VALUE)
                    break;
            }

            System.out.println("#" + tc + " " + min);
        }
    }

    static void combination(int depth, int start, int amount) {
        if(depth == amount) {
            int[][] tempArr = new int[N][N];

            for(int i=0; i<N; i++)
                tempArr[i] = maxinos[i].clone();

            DFS(tempArr, 0, 0);
            return;
        }

        for(int i=start; i<coreList.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(depth+1, i, amount);
                visited[i] = false;
            }
        }
    }

    static void DFS(int[][] tempArr, int depth, int length) {
        if(depth == coreList.size()) {
            min = Math.min(min, length);
            return;
        }

        if(!visited[depth]) {
            DFS(tempArr, depth+1, length);
            return;
        }

        for(int d=0; d<4; d++) {
            int tempLength = 0;
            int nowR = coreList.get(depth).r;
            int nowC = coreList.get(depth).c;
            int nextR = nowR;
            int nextC = nowC;

            while(true) {
                nextR += dr[d];
                nextC += dc[d];

                if(outOfMapCheck(nextR, nextC)) {
                    DFS(tempArr, depth+1, length+tempLength);
                    break;
                }

                if(!emptyCheck(tempArr, nextR, nextC))
                    break;

                tempArr[nextR][nextC] = 2;
                tempLength++;
            }

            while(true) {
                nextR -= dr[d];
                nextC -= dc[d];

                if(nextR == nowR && nextC == nowC)
                    break;

                tempArr[nextR][nextC] = 0;
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }

    static boolean emptyCheck(int[][] tempArr, int r, int c) {
        return tempArr[r][c] == 0;
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
