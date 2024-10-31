package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_18512_점프_점프 {

    static int X, Y, P1, P2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        P1 = Integer.parseInt(st.nextToken());
        P2 = Integer.parseInt(st.nextToken());

        if(P1 == P2) {
            System.out.println(P1);
            return;
        }

        boolean[] pointArr = new boolean[10001];
        int nextX = P1;
        int nextY = P2;

        if(P1 > P2) {
            pointArr[P1] = true;

            while(true) {
                if(nextX > 10000)
                    break;

                pointArr[nextX] = true;
                nextX += X;
            }

            while(true) {
                if(nextY > 10000) {
                    System.out.println(-1);
                    break;
                }

                if(pointArr[nextY]) {
                    System.out.println(nextY);
                    break;
                }

                nextY += Y;
            }
        }
        else {
            pointArr[P2] = true;

            while(true) {
                if(nextY > 10000)
                    break;

                pointArr[nextY] = true;
                nextY += Y;
            }

            while(true) {
                if(nextX > 10000) {
                    System.out.println(-1);
                    break;
                }

                if(pointArr[nextX]) {
                    System.out.println(nextX);
                    break;
                }

                nextX += X;
            }
        }
    }
}
