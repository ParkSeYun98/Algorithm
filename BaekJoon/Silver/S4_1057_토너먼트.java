package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1057_토너먼트 {

    static int N, A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int round = 0;

        while(true) {
            if(A == B)
                break;

            if(A%2 == 0)
                A /= 2;
            else {
                A /= 2;
                A++;
            }

            if(B%2 == 0)
                B /= 2;
            else {
                B /= 2;
                B++;
            }

            round++;
        }

        System.out.println(round);
    }
}
