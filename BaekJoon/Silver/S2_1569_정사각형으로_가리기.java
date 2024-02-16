package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1569_정사각형으로_가리기 {

    static int N;
    static int maxX = -1000;
    static int minX = 1000;
    static int maxY = -1000;
    static int minY = 1000;

    static Point[] pointArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        pointArr = new Point[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            maxX = Math.max(maxX, X);
            minX = Math.min(minX, X);
            maxY = Math.max(maxY, Y);
            minY = Math.min(minY, Y);

            pointArr[i] = new Point(X, Y);
        }

        check();
    }

    public static void check() {
        int length = Math.max(maxX-minX, maxY-minY);
        int answer = -1;

        if(maxX-minX == maxY-minY) {
            answer = length;

            for (Point point : pointArr) {
                if(point.x != maxX && point.x != minX && point.y != maxY && point.y != minY)
                    answer = -1;
            }
        }
        else {
            int tempMaxX;
            int tempMinX;
            int tempMaxY;
            int tempMinY;

            for(int i=0; i<=length; i++) {
                if(maxX-minX > maxY-minY) {
                    tempMaxX = maxX;
                    tempMinX = minX;
                    tempMaxY = minY - i;
                    tempMinY = maxY + length;
                }
                else {
                    tempMaxX = minX + length;
                    tempMinX = maxX - i;
                    tempMaxY = maxY;
                    tempMinY = minY;
                }

                int cnt = 0;

                for(int j=0; j<N; j++) {
                    if(pointArr[j].x == tempMaxX || pointArr[j].x == tempMinX || pointArr[j].y == tempMaxY || pointArr[j].y == tempMinY)
                        cnt++;
                }

                if(cnt == N)
                    answer = length;
            }
        }

        System.out.println(answer);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
