/*
* Memory : 12420 KB
* Time : 556 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_16929_Two_Dots {

    static int N;
    static int M;
    static int startR;
    static int startC;
    static boolean flag;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                board[i][j] = input.charAt(j);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                flag = false;
                startR = i;
                startC = j;
                visited[i][j] = true;
                DFS(i, j, board[i][j], 1);
                visited[i][j] = false;

                if(flag) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    static void DFS(int nowR, int nowC, char alphabet, int cnt) {
        for(int d=0; d<4; d++) {
            int nextR = nowR + dr[d];
            int nextC = nowC + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(!cycleCheck(nextR, nextC, alphabet))
                continue;

            if(visited[nextR][nextC]) {
                if(nextR == startR && nextC == startC && cnt>=4) {
                    flag = true;
                    return;
                }

                continue;
            }

            visited[nextR][nextC] = true;
            DFS(nextR, nextC, alphabet, cnt+1);
            visited[nextR][nextC] = false;
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean cycleCheck(int r, int c, char alphabet) {
        return board[r][c] == alphabet;
    }
}
