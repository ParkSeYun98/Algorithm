package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1600_말이_되고픈_원숭이 {
    static int K;
    static int W;
    static int H;
    static int min = Integer.MAX_VALUE;

    static final int[] monkeydr = {0, 0, 1, -1};
    static final int[] monkeydc = {1, -1, 0, 0};
    static final int[] horsedr = {2, 1, -2, -1, 2, 1, -2, -1};
    static final int[] horsedc = {1, 2, -1, -2, -1, -2, 1, 2};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for(int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<W; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        BFS();

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, K, 0));

        boolean[][][] visited = new boolean[H][W][K+1];
        visited[0][0][K] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.r == H-1 && now.c == W-1)
                min = Math.min(min, now.cnt);

            if(now.chance > 0) {
                for(int d=0; d<8; d++) {
                    int nextR = now.r + horsedr[d];
                    int nextC = now.c + horsedc[d];

                    if(outofmapCheck(nextR, nextC))
                        continue;

                    if(wallCheck(nextR, nextC))
                        continue;

                    if(visited[nextR][nextC][now.chance-1])
                        continue;

                    queue.offer(new Point(nextR, nextC, now.chance-1, now.cnt+1));
                    visited[nextR][nextC][now.chance-1] = true;
                }
            }

            for(int d=0; d<4; d++) {
                int nextR = now.r + monkeydr[d];
                int nextC = now.c + monkeydc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC][now.chance])
                    continue;

                queue.offer(new Point(nextR, nextC, now.chance, now.cnt+1));
                visited[nextR][nextC][now.chance] = true;
            }
        }
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=H || c>=W;
    }

    static boolean wallCheck(int r, int c) {
        return map[r][c] == 1;
    }

    static class Point {
        int r;
        int c;
        int chance;
        int cnt;

        public Point(int r, int c, int chance, int cnt) {
            this.r = r;
            this.c = c;
            this.chance = chance;
            this.cnt = cnt;
        }
    }
}
