package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3_2588_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        String strB = String.valueOf(B);

        for(int i=strB.length()-1; i>=0; i--) {
            int partB = strB.charAt(i) - '0';

            System.out.println(A * partB);
        }

        System.out.println(A*B);
    }
}
