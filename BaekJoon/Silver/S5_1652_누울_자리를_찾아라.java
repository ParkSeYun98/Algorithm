/*
* Memory : 11624 KB
* Time : 76 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_1652_누울_자리를_찾아라 {

    static int N;
    static int row;
    static int col;

    static char[][] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        row = 0;
        col = 0;
        room = new char[N][N];

        for(int i=0; i<N; i++) {
            String temp = br.readLine();

            for(int j=0; j<temp.length(); j++)
                room[i][j] = temp.charAt(j);
        }

        sleepCheck();
    }

    static void sleepCheck() {
        for(int i=0; i<N; i++) {
            int tmp = 0;
            int tmp2 = 0;

            for(int j=0; j<N; j++) {
                if(room[i][j] == '.')
                    tmp++;
                else
                    tmp = 0;

                if(tmp == 2)
                    row++;
            }

            for(int j=0; j<N; j++) {
                if(room[j][i] == '.')
                    tmp2++;
                else
                    tmp2 = 0;

                if(tmp2 == 2)
                    col++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(row).append(" ").append(col).append("\n");

        System.out.println(sb);
    }
}
