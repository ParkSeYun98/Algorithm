package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_20436_ZOAC3 {

    static char left, right;
    static String input;
    static int dist;

    static char[][] leftarr = {{'q','w','e','r','t'},{'a','s','d','f','g'},{'z','x','c','v'}};
    static char[][] rightarr = {{'.','y','u','i','o','p'},{'.','h','j','k','l'},{'b','n','m'}};

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

        left = st.nextToken().charAt(0);
        right = st.nextToken().charAt(0);

        int leftStartR = -1;
        int leftStartC = -1;
        int rightStartR = -1;
        int rightStartC = -1;

        input = br.readLine();

        for(int i = 0; i < leftarr.length; i++) {
            for(int j = 0; j < leftarr[i].length; j++) {
                char c = leftarr[i][j];

                if(left == c) {
                    leftStartR = i;
                    leftStartC = j;
                }
            }
        }

        for(int i = 0; i < rightarr.length; i++) {
            for(int j = 0; j < rightarr[i].length; j++) {
                char c = rightarr[i][j];

                if(right == c) {
                    rightStartR = i;
                    rightStartC = j;
                }
            }
        }

        for(int k = 0; k < input.length(); k++) {
            char cur = input.charAt(k);

            int leftMoveR = -1;
            int leftMoveC = -1;
            int rightMoveR = -1;
            int rightMoveC = -1;

            for(int i = 0; i < leftarr.length; i++) {
                for(int j = 0; j < leftarr[i].length; j++) {
                    char c = leftarr[i][j];

                    if(cur == c) {
                        leftMoveR = i;
                        leftMoveC = j;
                    }
                }
            }

            if(leftMoveR != -1 && leftMoveC != -1) {
                dist += Math.abs(leftStartR - leftMoveR) + Math.abs(leftStartC - leftMoveC);
                dist++;

                leftStartR = leftMoveR;
                leftStartC = leftMoveC;

                continue;
            }

            for(int i = 0; i < rightarr.length; i++) {
                for(int j = 0; j < rightarr[i].length; j++) {
                    char c = rightarr[i][j];

                    if(cur == c) {
                        rightMoveR = i;
                        rightMoveC = j;
                    }
                }
            }

            if(rightMoveR != -1 && rightMoveC != -1) {
                dist += Math.abs(rightStartR - rightMoveR) + Math.abs(rightStartC - rightMoveC);
                dist++;

                rightStartR = rightMoveR;
                rightStartC = rightMoveC;

                continue;
            }
        }

        System.out.println(dist);
    }
}
