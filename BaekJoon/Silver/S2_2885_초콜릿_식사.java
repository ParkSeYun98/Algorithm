package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_2885_초콜릿_식사 {

    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        N = 1;

        while(true) {
            if(N < K)
                N *= 2;
            else {
                int k = K;
                int n = N;
                int cnt = 0;

                while(k > 0) {
                    if(k >= n)
                        k -= n;
                    else {
                        n /= 2;
                        cnt++;
                    }
                }

                System.out.println(N + " " + cnt);
                return;
            }
        }
    }
}
