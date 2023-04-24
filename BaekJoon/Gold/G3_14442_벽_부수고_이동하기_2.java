package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_14442_벽_부수고_이동하기_2 {
    static int N;
    static int M;
    static int K;

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j) - '0';
        }

        BFS();
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, K));

        boolean[][][] visited = new boolean[K+1][N][M];
        visited[K][0][0] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.r == N-1 && now.c == M-1) {
                System.out.println(now.cnt);
                return;
            }

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC)) {
                    if(now.chance > 0 && !visited[now.chance-1][nextR][nextC]) {
                        visited[now.chance - 1][nextR][nextC] = true;
                        queue.offer(new Point(nextR, nextC, now.cnt + 1, now.chance - 1));
                    }
                }
                else {
                    if(!visited[now.chance][nextR][nextC]) {
                        visited[now.chance][nextR][nextC] = true;
                        queue.offer(new Point(nextR, nextC, now.cnt+1, now.chance));
                    }
                }
            }
        }

        System.out.println(-1);
    }

    static boolean wallCheck(int nextR, int nextC) {
        return map[nextR][nextC] == 1;
    }

    static boolean outofmapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static class Point {
        int r;
        int c;
        int cnt;
        int chance;

        public Point(int r, int c, int cnt, int chance) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.chance = chance;
        }
    }
}
