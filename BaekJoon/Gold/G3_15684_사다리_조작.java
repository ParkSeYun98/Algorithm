package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_15684_사다리_조작 {
    private static int N;
    private static int M;
    private static int H;
    private static int result;
    private static boolean flag;

    // 하 우 좌
    private static final int[] dr = {1, 0, 0};
    private static final int[] dc = {0, 1, -1};

    private static int[][] ladder;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new int[H][N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladder[a-1][b-1] = 1;
            ladder[a-1][b] = 2;
        }

        int t= 0;
        while(true) {
            if(t > 3) {
                result = -1;
                break;
            }

            flag = false;
            visited = new boolean[H][N];

            Combination(0, t);

            if(flag) {
                result = t;
                break;
            }

            t++;
        }

        System.out.println(result);
    }

    public static void Combination(int depth, int goal) {
        if(depth == goal) {
            if(check())
                flag = true;

            return;
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<N-1; j++) {
                if(ladder[i][j] == 0 && ladder[i][j+1] == 0 && !visited[i][j]) {
                    ladder[i][j] = 1;
                    ladder[i][j+1] = 2;
                    visited[i][j] = true;
                    Combination(depth+1, goal);
                    visited[i][j] = false;
                    ladder[i][j] = 0;
                    ladder[i][j+1] = 0;
                }
            }
        }
    }

    public static boolean check() {
        for(int i=0; i<N; i++) {
            int x = 0;
            int y = i;

            for(int j=0; j<H; j++) {
                if(ladder[x][y] == 1)
                    y++;
                else if(ladder[x][y] == 2)
                    y--;

                x++;
            }

            if(y != i)
                return false;
        }
        return true;
    }

    public static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=H || c>=N;
    }

    public static class Point {
        int r;
        int c;
        int value;

        public Point(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }
}
