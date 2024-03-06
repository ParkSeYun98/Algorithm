/*
* Memory : 304828 KB
* Time : 1352 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class G4_2580_스도쿠 {

    static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sudoku = new int[9][9];

        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<9; j++)
                sudoku[i][j] = Integer.parseInt(st.nextToken());
        }

        fillEmpty(0, 0);
    }

    static void fillEmpty(int r, int c) {
        if(r == 9) {
            for(int i=0; i<9; i++) {
                for(int j=0; j<9; j++)
                    System.out.print(sudoku[i][j] + " ");

                if(i != 8)
                    System.out.println();
            }

            exit(0);
        }

        if(c == 9) {
            fillEmpty(r+1, 0);
            return;
        }

        if(sudoku[r][c] == 0) {
            for(int i=1; i<=9; i++) {
                if(!rowCheck(r, c, i) || !colCheck(r, c, i) || !boxCheck(r, c, i))
                    continue;

                sudoku[r][c] = i;
                fillEmpty(r, c+1);
                sudoku[r][c] = 0;
            }
        }
        else
            fillEmpty(r, c+1);
    }

    static boolean rowCheck(int r, int c, int input) {
        int[] checkArr = new int[10];

        for(int i=1; i<=9; i++)
            checkArr[sudoku[r][i-1]]++;

        for(int i=1; i<=9; i++) {
            if(checkArr[i]==0 && i==input)
                return true;
        }

        return false;
    }

    static boolean colCheck(int r, int c, int input) {
        int[] checkArr = new int[10];

        for(int i=1; i<=9; i++)
            checkArr[sudoku[i-1][c]]++;

        for(int i=1; i<=9; i++) {
            if(checkArr[i]==0 && i==input)
                return true;
        }

        return false;
    }

    static boolean boxCheck(int r, int c, int input) {
        int startR = 0;
        int startC = 0;
        int[] checkArr = new int[10];

        if(r/3 == 1)
            startR = 3;
        else if(r/3 == 2)
            startR = 6;

        if(c/3 == 1)
            startC = 3;
        else if(c/3 == 2)
            startC = 6;

        for(int i=startR; i<startR+3; i++) {
            for(int j=startC; j<startC+3; j++)
                checkArr[sudoku[i][j]]++;
        }

        for(int i=1; i<=9; i++) {
            if(checkArr[i]==0 && i==input)
                return true;
        }

        return false;
    }
}
