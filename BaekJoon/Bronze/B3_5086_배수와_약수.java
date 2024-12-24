package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_5086_배수와_약수 {

    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if(A==0 && B==0)
                break;

            if(B%A == 0)
                System.out.println("factor");
            else if(A%B == 0)
                System.out.println("multiple");
            else
                System.out.println("neither");
        }
    }
}
