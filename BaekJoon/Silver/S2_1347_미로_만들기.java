package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2_1347_미로_만들기 {

    static int len;
    static String move;

    // F R B L
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        len = Integer.parseInt(br.readLine());

        move = br.readLine();

        map = new char[101][101];

        for(int i=0; i<map.length; i++)
            Arrays.fill(map[i], '#');

        makeMaze();
    }

    static void makeMaze() {
        int nowR = 50;
        int nowC = 50;
        int dir = 0;

        map[nowR][nowC] = '.';

        for(int i=0; i<move.length(); i++) {
            char now = move.charAt(i);

            if(now == 'R') {
                if(dir == 0)
                    dir = 3;
                else
                    dir--;
            }
            else if(now == 'L')
                dir = (dir + 1) % 4;
            else if(now == 'F') {
                nowR += dr[dir];
                nowC += dc[dir];
                map[nowR][nowC] = '.';
            }
        }

        cutMaze();
    }

    static void cutMaze() {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;

        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                if(map[i][j] == '.') {
                    if(minR > i)
                        minR = i;
                    if(minC > j)
                        minC = j;
                    if(maxR < i)
                        maxR = i;
                    if(maxC < j)
                        maxC = j;
                }
            }
        }

        for(int i=minR; i<=maxR; i++) {
            for(int j=minC; j<=maxC; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }
}
