package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3_10872_팩토리얼 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(Factorial(N));
    }

    static long Factorial(int N) {
        long sum = 1;

        while(N > 0) {
            sum *= N;
            N--;
        }

        return sum;
    }
}
