package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G2_17136_색종이_붙이기 {
    static int min = Integer.MAX_VALUE;

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[10][10];

        for(int i=0; i<10; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<10; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] paper = new int[6];
        visited = new boolean[10][10];

        Arrays.fill(paper, 5);

        Check(0, 0, 0, paper);

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void Check(int r, int c, int cnt, int[] paper) {
        if(zeroCheck()) {
            min = Math.min(min, cnt);
            return;
        }

        int nowR = r;
        int nowC = c;

        if(nowC >= 10) {
            nowR += 1;
            nowC = 0;
        }

        if(nowR >= 10) {
            min = Math.min(min, cnt);
            return;
        }

        if(rectangleCheck(nowR, nowC, 1) && paper[1]>0) {
            paper[1]--;
            mapChange(nowR, nowC, 1, 0);
            Check(nowR, nowC+1, cnt+1, paper);
            mapChange(nowR, nowC, 1, 1);
            paper[1]++;
        }

        if(nowR<=8 && nowC<=8 && rectangleCheck(nowR, nowC, 2) && paper[2]>0) {
            paper[2]--;
            mapChange(nowR, nowC, 2, 0);
            Check(nowR, nowC+1, cnt+1, paper);
            mapChange(nowR, nowC, 2, 1);
            paper[2]++;
        }

        if(nowR<=7 && nowC<=7 && rectangleCheck(nowR, nowC, 3) && paper[3]>0) {
            paper[3]--;
            mapChange(nowR, nowC, 3, 0);
            Check(nowR, nowC+1, cnt+1, paper);
            mapChange(nowR, nowC, 3, 1);
            paper[3]++;
        }

        if(nowR<=6 && nowC<=6 && rectangleCheck(nowR, nowC, 4) && paper[4]>0) {
            paper[4]--;
            mapChange(nowR, nowC, 4, 0);
            Check(nowR, nowC+1, cnt+1, paper);
            mapChange(nowR, nowC, 4, 1);
            paper[4]++;
        }

        if(nowR<=5 && nowC<=5 && rectangleCheck(nowR, nowC, 5) && paper[5]>0) {
            paper[5]--;
            mapChange(nowR, nowC, 5, 0);
            Check(nowR, nowC+1, cnt+1, paper);
            mapChange(nowR, nowC, 5, 1);
            paper[5]++;
        }

        if(map[nowR][nowC] == 0)
            Check(nowR, nowC+1, cnt, paper);
    }

    static boolean zeroCheck() {
        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if(map[i][j] != 0)
                    return false;
            }
        }

        return true;
    }

    static boolean rectangleCheck(int r, int c, int idx) {
        for(int i=r; i<r+idx; i++) {
            for(int j=c; j<c+idx; j++) {
                if(map[i][j] != 1)
                    return false;
            }
        }

        return true;
    }

    static void mapChange(int r, int c, int idx, int value) {
        for(int i=r; i<r+idx; i++) {
            for(int j=c; j<c+idx; j++)
                map[i][j] = value;
        }
    }
}
