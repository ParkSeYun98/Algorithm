package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1_17143_낚시왕 {
    static int R;
    static int C;
    static int M;
    static int cnt = 0;

    // 상 좌 하 우
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};

    static Point[][] map;

    static List<Point> sharkList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Point[R][C];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            map[r-1][c-1] = new Point(r-1, c-1, s, d-1, z);
        }

        process();

        System.out.println(cnt);
    }

    static void process() {
        for(int i=0; i<C; i++) {
            kill(i);

            sharkMove();
        }
    }

    static void kill(int c) {
        for(int i=0; i<R; i++) {
            if(map[i][c] != null) {
                cnt += map[i][c].z;
                map[i][c] = null;
                break;
            }
        }
    }

    static void sharkMove() {
        Queue<Point> queue = new LinkedList<>();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j] != null)
                    queue.offer(new Point(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
            }
        }

        map = new Point[R][C];

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            int speed = now.s;

            // 상 하
            if(now.d == 0 || now.d == 1)
                speed %= (R-1)*2;
            else
                speed %= (C-1)*2;

            for(int s=0; s<speed; s++) {
                int nextR = now.r + dr[now.d];
                int nextC = now.c + dc[now.d];

                if(outofmapCheck(nextR, nextC)) {
                    now.r -= dr[now.d];
                    now.c -= dc[now.d];

                    if(now.d == 0)
                        now.d = 1;
                    else if(now.d == 1)
                        now.d = 0;
                    else if(now.d == 2)
                        now.d = 3;
                    else
                        now.d = 2;

                    continue;
                }

                now.r = nextR;
                now.c = nextC;
            }

            // 이미 그 공간에 상어가 있다면
            if(map[now.r][now.c] != null) {
                if(map[now.r][now.c].z < now.z)
                    map[now.r][now.c] = new Point(now.r, now.c, now.s, now.d, now.z);
            }
            else
                map[now.r][now.c] = new Point(now.r, now.c, now.s, now.d, now.z);
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r < 0 || c < 0 || r >= R || c >= C;
    }

    static class Point {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Point(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
