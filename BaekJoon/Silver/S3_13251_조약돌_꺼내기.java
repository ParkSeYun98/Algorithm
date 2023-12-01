/*
* Memory : 11664 KB
* Time : 80 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_13251_조약돌_꺼내기 {

    private static int M;
    private static int K;
    private static int sum;

    private static int[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());

        stone = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
            sum += stone[i];
        }

        K = Integer.parseInt(br.readLine());

        getRatio();
    }

    public static void getRatio() {
        double result = 0d;

        for(int i=0; i<M; i++) {
            double ratio = 1d;

            if(stone[i] >= K) {
                for (int j = 0; j < K; j++)
                    ratio *= ((double) (stone[i] - j) / (sum - j));

                result +=  ratio;
            }
        }

        System.out.println(result);
    }
}
