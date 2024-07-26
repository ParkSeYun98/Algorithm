package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_6588_골드바흐의_추측 {

    static int N;

    static boolean[] primeArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        primeArr = new boolean[1000001];

        primeCheck();

        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0)
                break;

            int result = -1;

            for(int i=2; i<=N/2; i++) {

                if(!primeArr[i] && (i%2 == 1) && !primeArr[N-i] && ((N-i)%2 == 1)) {
                    result = i;
                    break;
                }
            }

            if(result != -1)
                System.out.println(N + " = " + result + " + " + (N-result));
        }
    }

    static void primeCheck() {
        primeArr[0] = true;
        primeArr[1] = true;

        for (int i = 2; i <= (int) Math.sqrt(1000000); i++) {
            for (int j = 2; i * j < 1000001; j++)
                primeArr[i * j] = true;
        }
    }
}
