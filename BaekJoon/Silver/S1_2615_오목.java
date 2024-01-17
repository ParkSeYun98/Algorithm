/*
* Memory : 11592 KB
* Time : 80 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2615_오목 {

    static int winner;
    static boolean sixFlag;

    static int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dc = {1, 1, 1, 0, -1, -1, -1, 0};

    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        winner = 0;
        board = new int[19][19];
        visited = new boolean[19][19];

        for(int i=0; i<19; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<19; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        whoWin();
    }

    static void whoWin() {
        for(int i=0; i<19; i++) {
            for(int j=0; j<19; j++) {
                if(board[i][j] != 0) {
                    for(int d=0; d<4; d++) {
                        sixFlag = false;

                        check(i, j, 1, d);

                        if(!sixFlag && winner != 0) {
                            int nextR = i + dr[d+4];
                            int nextC = j + dc[d+4];

                            if(!outofBoardCheck(nextR, nextC)) {
                                if(board[nextR][nextC] == board[i][j])
                                    winner = 0;
                            }

                            if(winner != 0) {
                                System.out.println(winner);
                                System.out.println((i+1) + " " + (j+1));

                                return;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(winner);
    }

    static void check(int r, int c, int depth, int direction) {
        int nextR = r + dr[direction];
        int nextC = c + dc[direction];

        if(depth == 5) {
            if(outofBoardCheck(nextR, nextC)) {
                winner = board[r][c];
                return;
            }

            if(board[nextR][nextC] == board[r][c])
                sixFlag = true;
            else
                 winner = board[r][c];
            return;

        }

        if(outofBoardCheck(nextR, nextC))
            return;

        if(visited[nextR][nextC])
            return;

        if(board[nextR][nextC] != board[r][c])
            return;

        visited[nextR][nextC] = true;
        check(nextR, nextC, depth+1, direction);

        if(!sixFlag)
            visited[nextR][nextC] = false;
    }

    static boolean outofBoardCheck(int r, int c) {
        return r<0 || c<0 || r>=19 || c>=19;
    }
}
