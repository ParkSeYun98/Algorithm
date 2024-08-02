package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_10655_마라톤1 {

    static int N, min;

    static boolean[] visited;
    static Point[] checkPoint;

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

        N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        visited = new boolean[N];
        checkPoint = new Point[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            checkPoint[i] = new Point(x, y);
        }

        getMinDist();

        System.out.println(min);
    }

    static void getMinDist() {
        int sum = 0;

        for (int i=0; i < checkPoint.length - 1; i++)
            sum += getDist(i, i + 1);

        for (int i=1; i<checkPoint.length - 1; i++) {
            int temp = sum - (getDist(i, i+1) + getDist(i, i-1)) + getDist(i-1, i+1);

            min = Math.min(temp, min);
        }
    }

    static int getDist(int first, int second) {
        return Math.abs(checkPoint[first].r - checkPoint[second].r) + Math.abs(checkPoint[first].c - checkPoint[second].c);
    }
}
