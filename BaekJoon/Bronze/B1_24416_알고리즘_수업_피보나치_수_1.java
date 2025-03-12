package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_24416_알고리즘_수업_피보나치_수_1 {

    static int cnt1 = 0;
    static int cnt2 = 0;

    static int[] f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        f = new int[n+1];
        f[1] = 1;
        f[2] = 1;

        fibo1(n);
        fibo2(n);

        System.out.println(cnt1 + " " + cnt2);
    }

    static int fibo1(int n) {
        if(n==1 || n==2) {
            cnt1++;
            return 1;
        }
        else
            return fibo1(n-1)+fibo1(n-2);
    }

    static int fibo2(int n) {
        for(int i=3; i<=n; i++) {
            cnt2++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
