package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_10448_유레카_이론 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[45];

        for(int i=0; i<arr.length; i++)
            arr[i] = (i*(i+1)) / 2;

        for(int tc=0; tc<T; tc++) {
            int K = Integer.parseInt(br.readLine());

            System.out.println(func(K, arr));
        }
    }

    static int func(int K, int[] arr) {
        for(int i=1; i<arr.length; i++) {
            for(int j=1; j<arr.length; j++) {
                for(int k=1; k<arr.length; k++) {
                    int sum = arr[i] + arr[j] + arr[k];

                    if(sum == K)
                        return 1;
                }
            }
        }

        return 0;
    }
}
