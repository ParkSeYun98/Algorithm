/*
* Memory : 11500 KB
* Time : 80 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_1331_나이트_투어 {

    private static int[] dr = {2, 2, -2, -2, 1, -1, 1, -1};
    private static int[] dc = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Point[] route = new Point[37];
        boolean[][] visited = new boolean[7][7];

        for(int i=0; i<36; i++) {
            String temp = br.readLine();

            route[i] = new Point(temp.charAt(0)-64, temp.charAt(1)-48);
        }

        route[36] = new Point(route[0].r, route[0].c);

        for(int i=1; i<route.length; i++) {
            if(visited[route[i].r][route[i].c]) {
                System.out.println("Invalid");
                return;
            }

            boolean flag = false;

            for(int d=0; d<8; d++) {
                if(route[i-1].r + dr[d] == route[i].r && route[i-1].c + dc[d] == route[i].c) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                System.out.println("Invalid");
                return;
            }

            visited[route[i].r][route[i].c] = true;
        }

        System.out.println("Valid");
    }

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
