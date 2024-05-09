package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_10472_십자뒤집기 {

    static final int INF = 987654321;
    static final int BLACK = '*';
    static final int WHITE = '.';
    static final int SIZE = 3;

    static int P;

    static int[] dr = {0, 0, 0, 1, -1};
    static int[] dc = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        P = Integer.parseInt(br.readLine());

        for(int tc=0; tc<P; tc++) {

            char[][] board = new char[SIZE][SIZE];

            for(int i=0; i<SIZE; i++) {
                String input = br.readLine();

                for(int j=0; j<input.length(); j++)
                    board[i][j] = input.charAt(j);
            }

            System.out.println(DFS(0, 0, board));
        }
    }

    static int DFS(int r, int c, char[][] board) {
        int result = INF;

        if(r == SIZE) {
            for(int i=0; i<SIZE; i++) {
                for(int j=0; j<SIZE; j++) {
                    if(board[i][j] == BLACK)
                        return INF;
                }
            }

            return 0;
        }

        int nextR = r;
        int nextC = c + 1;

        if(nextC >= SIZE) {
            nextR = r + 1;
            nextC = 0;
        }

        result = Math.min(result, DFS(nextR, nextC, board));

        for(int d=0; d<5; d++) {
            int nR = r + dr[d];
            int nC = c + dc[d];

            if(outOfMapCheck(nR, nC))
                continue;

            if(board[nR][nC] == BLACK)
                board[nR][nC] = WHITE;
            else
                board[nR][nC] = BLACK;
        }

        result = Math.min(result, DFS(nextR, nextC, board) + 1);

        for(int d=0; d<5; d++) {
            int nR = r + dr[d];
            int nC = c + dc[d];

            if(outOfMapCheck(nR, nC))
                continue;

            if(board[nR][nC] == BLACK)
                board[nR][nC] = WHITE;
            else
                board[nR][nC] = BLACK;
        }

        return result;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=SIZE || c>=SIZE;
    }
}
