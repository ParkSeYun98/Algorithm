package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_17286_유미 {

    static double min, dist;

    static boolean[] visited;
    static Point[] peopleArr;

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
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Point yumi = new Point(r, c);

        min = Integer.MAX_VALUE;
        dist = 0;
        visited = new boolean[3];
        peopleArr = new Point[3];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            peopleArr[i] = new Point(x, y);
        }

        DFS(0, yumi);

        System.out.println((int) min);
    }

    static void DFS(int depth, Point start) {
        if(depth == 3) {
            if(min > dist)
                min = dist;

            return;
        }

        for(int i=0; i<peopleArr.length; i++) {
            Point now = peopleArr[i];
            double temp = getDistance(start, now);

            if(!visited[i]) {
                visited[i] = true;
                dist += temp;
                DFS(depth+1, now);
                dist -= temp;
                visited[i] = false;
            }
        }
    }

    static double getDistance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.r - b.r, 2) + Math.pow(a.c - b.c, 2));
    }
}
