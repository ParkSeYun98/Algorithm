package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_16973_직사각형_탈출 {

    static int N, M, H, W, Sr, Sc, Fr, Fc;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] square;

    static List<Point> wallList;

    static class Point {
        int r;
        int c;
        int cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        square = new int[N][M];
        wallList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st= new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());

                if(square[i][j] == 1)
                    wallList.add(new Point(i, j, 0));
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken()) - 1;
        Sc = Integer.parseInt(st.nextToken()) - 1;
        Fr = Integer.parseInt(st.nextToken()) - 1;
        Fc = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(BFS());
    }

    static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(Sr, Sc, 0));

        boolean[][] visited = new boolean[N][M];
        visited[Sr][Sc] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();
            
            if(now.r == Fr && now.c == Fc)
                return now.cnt;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC, now.cnt+1));
                visited[nextR][nextC] = true;
            }
        }

        return -1;
    }

    static boolean outOfMapCheck(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= M || r+H-1 >= N || c+W-1 >= M;
    }

    static boolean wallCheck(int r, int c) {
        for (Point point : wallList) {
            if(point.r >= r && point.c >=c && point.r <= r+H-1 && point.c <= c+W-1)
                return true;
        }

        return false;
    }
}
