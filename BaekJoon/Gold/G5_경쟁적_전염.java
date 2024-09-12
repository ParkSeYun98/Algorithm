package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_경쟁적_전염 {

    static int N, K, S, X, Y;

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] arr;

    static List<Point> virusList;
    static Queue<Point> queue;

    static class Point {
        int r;
        int c;
        int virus;
        int t;

        public Point(int r, int c, int virus, int t) {
            this.r = r;
            this.c = c;
            this.virus = virus;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        virusList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] != 0)
                    virusList.add(new Point(i, j, arr[i][j], 0));
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        virusList.sort(Comparator.comparingInt(o -> o.virus));

        queue = new LinkedList<>();

        for (Point point : virusList)
            queue.offer(point);

        spreadVirus();

        System.out.println(arr[X-1][Y-1]);
    }

    static void spreadVirus() {
        while(!queue.isEmpty()) {
            Point now = queue.poll();

            if(now.t == S)
                return;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(arr[nextR][nextC] == 0) {
                    queue.offer(new Point(nextR, nextC, now.virus, now.t+1));
                    arr[nextR][nextC] = now.virus;
                }
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=N;
    }
}
