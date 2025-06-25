package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S3_1485_정사각형 {

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

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            Point[] rectangle = new Point[4];

            for(int i=0; i<4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                rectangle[i] = new Point(r, c);
            }

            if(check(rectangle))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    static boolean check(Point[] rectangle) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<3; i++) {
            Point A = rectangle[i];

            for(int j=i+1; j<4; j++) {
                Point B = rectangle[j];

                set.add(Math.abs(B.r - A.r) + Math.abs(B.c - A.c));
            }
        }

        return set.size() == 2;
    }
}
