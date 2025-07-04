package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_10870_피보나치_수_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }

    static int fibo(int n) {
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        return fibo(n-1) + fibo(n-2);
    }
}
