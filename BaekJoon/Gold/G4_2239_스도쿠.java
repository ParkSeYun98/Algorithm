package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G4_2239_스도쿠 {
    static int[][] sudoku;

    static Map<Integer, Point> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[10][10];
        map = new HashMap<>();

        int idx = 0;

        for(int i=1; i<=9; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                sudoku[i][j+1] = input.charAt(j) - '0';

                map.put(++idx, new Point(i, j+1));
            }
        }

        Backtracking(1);
    }

    static void Backtracking(int depth) {
        if(depth == 82) {
            print();
            System.exit(0);
        }

        int r = map.get(depth).r;
        int c = map.get(depth).c;

        if(!zeroCheck(r, c)) {
            Backtracking(depth + 1);
            return;
        }

        for(int i=1; i<=9; i++) {
            if(rowCheck(r, i) && colCheck(c, i) && boxCheck(r, c, i)) {
                sudoku[r][c] = i;
                Backtracking(depth+1);
                sudoku[r][c] = 0;
            }
        }
    }

    static boolean zeroCheck(int r, int c) {
        return sudoku[r][c] == 0;
    }

    static boolean rowCheck(int r, int i) {
        for(int a=1; a<=9; a++) {
            if(sudoku[r][a] == i)
                return false;
        }

        return true;
    }

    static boolean colCheck(int c, int i) {
        for(int a=1; a<=9; a++) {
            if(sudoku[a][c] == i)
                return false;
        }

        return true;
    }

    static boolean boxCheck(int r, int c, int i) {
        int startR;
        int startC;

        if(r>=1 && r<=3)
            startR = 1;
        else if(r<=6)
            startR = 4;
        else
            startR = 7;

        if(c>=1 && c<=3)
            startC = 1;
        else if(c<=6)
            startC = 4;
        else
            startC = 7;

        for(int a=startR; a<startR+3; a++) {
            for(int b=startC; b<startC+3; b++) {
                if(sudoku[a][b] == i)
                    return false;
            }
        }

        return true;
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++)
                sb.append(sudoku[i][j]);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
