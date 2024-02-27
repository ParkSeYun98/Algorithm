package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S4_1459_걷기 {

    static final int MAXX = 1_000_000_000;
    static final int MAXY = 1_000_000_000;

    static int X, Y, W, S;

    static int[] dr = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    static class Point {
        int r;
        int c;
        int time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        goHome();
    }

    static void goHome() {
        int min;
        int diff = Math.abs(X-Y);
        long time = 0;

        if(X < Y)
            min = X;
        else
            min = Y;

        if(2*W > S) {
            time += ((long) min * S);

            if(W > S && diff > 1) {
                time += ((diff/2) * (2L*S));
                time += (diff%2 * W);
            }
            else
                time += ((long) diff * W);
        }
        else
            time += (long) (X + Y) *W;

        System.out.println(time);
    }
}
