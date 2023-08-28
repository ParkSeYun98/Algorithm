package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_16918_봄버맨 {

    private static int R;
    private static int C;
    private static int N;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    private static char[][] map;

    private static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int i=0; i<R; i++) {
            String temp = br.readLine();

            for(int j=0; j<C; j++)
                map[i][j] = temp.charAt(j);
        }

        for(int i=2; i<=N; i++) {
            if(i%2 == 1) {
                for(int j=0; j<R; j++) {
                    for(int k=0; k<C; k++) {
                        if(map[j][k] == 'O')
                            queue.offer(new Point(j, k));
                    }
                }

                for(int j=0; j<map.length; j++)
                    Arrays.fill(map[j], 'O');

                BFS();
            }
        }

        if(N % 2 == 0) {
            for(int i=0; i<map.length; i++)
                Arrays.fill(map[i], 'O');
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }

    public static void BFS() {
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            int r = now.r;
            int c = now.c;

            map[r][c] = '.';

            for(int d=0; d<4; d++) {
                int nextR = r + dx[d];
                int nextC = c + dy[d];

                if(outofmapCheck(nextR, nextC))
                    continue;

                map[nextR][nextC] = '.';
            }
        }
    }

    public static boolean outofmapCheck(int r, int c) {
        if(r<0 || c<0 || r>=R || c>=C)
            return true;
        return false;
    }

    public static class Point {
        private int r;
        private int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
