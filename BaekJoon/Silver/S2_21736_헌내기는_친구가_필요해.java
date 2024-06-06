package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_21736_헌내기는_친구가_필요해 {

    static int N, M, cnt;
    static Point start;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static char[][] campus;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = 0;
        campus = new char[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++) {
                campus[i][j] = input.charAt(j);

                if(campus[i][j] == 'I')
                    start = new Point(i, j);
            }
        }

        BFS();

        if(cnt == 0)
            System.out.println("TT");
        else
            System.out.println(cnt);
    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        boolean[][] visited = new boolean[N][M];
        visited[start.r][start.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(campus[now.r][now.c] == 'P')
                cnt++;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean wallCheck(int r, int c) {
        return campus[r][c] == 'X';
    }
}
