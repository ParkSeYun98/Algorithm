package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_4396_지뢰_찾기 {

    static int n;

    static int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    static char[][] board;
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

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                board[i][j] = input.charAt(j);
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        String[][] arr = new String[n][n];

        for(int i=0; i<n; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                char now = input.charAt(j);

                String result = "";

                if(now == 'x') {
                    result = find(new Point(i, j));

                    if(result.equals("*"))
                        flag = true;

                    arr[i][j] = result;
                }
                else
                    arr[i][j] = ".";
            }
        }

        if(flag) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(board[i][j] == '*')
                        arr[i][j] = "*";
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0;j<n; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        }
    }

    static String find(Point start) {
        int cnt = 0;

        if(board[start.r][start.c] == '*')
            return "*";

        for(int d=0; d<8; d++) {
            int nextR = start.r + dr[d];
            int nextC = start.c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(board[nextR][nextC] == '*')
                cnt++;

            visited[nextR][nextC] = true;
        }

        return String.valueOf(cnt);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=n || c>=n;
    }
}
