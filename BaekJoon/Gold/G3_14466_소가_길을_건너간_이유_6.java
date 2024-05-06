package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_14466_소가_길을_건너간_이유_6 {

    static int N, K, R, cnt;

    static Point[] cow;

    static boolean[][] visited;

    static List<Point>[][] bridge;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

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
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        cnt = 0;
        cow = new Point[K];
        bridge = new ArrayList[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                bridge[i][j] = new ArrayList<>();
        }

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            Point p1 = new Point(r1 ,c1);

            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            Point p2 = new Point(r2, c2);

            bridge[p1.r][p1.c].add(p2);
            bridge[p2.r][p2.c].add(p1);
        }

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            cow[i] = new Point(r, c);
        }

        move();

        System.out.println(cnt);
    }

    static void move() {
        for(int i=0; i<K; i++) {
            visited = new boolean[N][N];

            BFS(cow[i]);

            for(int j=i; j<K; j++) {
                Point now = cow[j];

                if(!visited[now.r][now.c])
                    cnt++;
            }
        }
    }

    static void BFS(Point start) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        visited[start.r][start.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            outer : for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                Point nextP = new Point(nextR, nextC);

                for (Point point : bridge[now.r][now.c]) {
                    if(point.r == nextR && point.c == nextC)
                        continue outer;
                }

                queue.offer(nextP);
                visited[nextP.r][nextP.c] = true;
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }
}
