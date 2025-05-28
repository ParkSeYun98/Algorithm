package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_20125_쿠키의_신체_측정 {

    static int N, leftArm, rightArm, waist, leftLeg, rightLeg;

    static Point heart, waistTail;

    static char[][] map;

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

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j);
        }

        solve();

        System.out.println(heart.r + " " + heart.c);
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }

    static void solve() {
        findHeart();
        findLeftArm();
        findRightArm();
        findWaist();
        findLeftLeg();
        findRightLeg();
    }

    static void findHeart() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == '*') {
                    heart = new Point(i+2, j+1);

                    return;
                }
            }
        }
    }

    static void findLeftArm() {
        for(int i=0; i<heart.c-1; i++) {
            if(map[heart.r-1][i] == '*')
                leftArm++;
        }
    }

    static void findRightArm() {
        for(int i=heart.c; i<N; i++) {
            if(map[heart.r-1][i] == '*')
                rightArm++;
        }
    }

    static void findWaist() {
        for(int i=heart.r; i<N; i++) {
            if(map[i][heart.c-1] == '*') {
                waist++;
                waistTail = new Point(i+1, heart.c);
            }
        }
    }

    static void findLeftLeg() {
        for(int i=waistTail.r; i<N; i++) {
            if(map[i][waistTail.c-2] == '*')
                leftLeg++;
        }
    }

    static void findRightLeg() {
        for(int i=waistTail.r; i<N; i++) {
            if(map[i][waistTail.c] == '*')
                rightLeg++;
        }
    }
}
