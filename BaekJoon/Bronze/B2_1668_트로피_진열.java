package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_1668_트로피_진열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());


        int maxA = arr[0];
        int maxB = arr[N-1];
        int cntA = 1;
        int cntB = 1;

        for(int i=1; i<N; i++) {
            if(maxA < arr[i]) {
                maxA = arr[i];
                cntA++;
            }

            if(maxB < arr[N-i-1]) {
                maxB = arr[N-i-1];
                cntB++;
            }
        }

        System.out.println(cntA);
        System.out.println(cntB);
    }
}
