package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_2210_숫자판_점프 {

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] board;

    static List<String> list;

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

        board = new int[5][5];
        list = new ArrayList<>();

        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<5; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++)
                DFS(0, new Point(i, j), "");
        }

        System.out.println(list.size());
    }

    static void DFS(int depth, Point point, String str) {
        if(depth == 6) {
            if(!list.contains(str))
                list.add(str);

            return;
        }

        String newStr = str + board[point.r][point.c];

        for(int d=0; d<4; d++) {
            int nextR = point.r + dr[d];
            int nextC = point.c + dc[d];

            if(outOfMapCheck(nextR, nextC))
                continue;

            DFS(depth+1, new Point(nextR, nextC), newStr);
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=5 || c>=5;
    }
}
