package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_13901_로봇 {

    static int R, C, k, sr, sc;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int[] dirOrder;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        k = Integer.parseInt(br.readLine());

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());

        dirOrder = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++)
            dirOrder[i] = Integer.parseInt(st.nextToken())-1;

        move();

        System.out.println(sr + " " + sc);
    }

    static void move() {
        boolean[][] visited = new boolean[R][C];
        visited[sr][sc] = true;

        int dir = 0;
        int cnt = 0;

        while(true) {
            if(cnt == 4)
                break;

            int nextR = sr + dr[dirOrder[dir]];
            int nextC = sc + dc[dirOrder[dir]];

            if(outOfMapCheck(nextR, nextC) || wallCheck(nextR, nextC) || visited[nextR][nextC]) {
                dir = (dir+1) % 4;
                cnt++;
                continue;
            }

            sr = nextR;
            sc = nextC;
            visited[nextR][nextC] = true;
            cnt = 0;
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=R || c>=C;
    }

    static boolean wallCheck(int r, int c) {
        return map[r][c]==1;
    }
}
