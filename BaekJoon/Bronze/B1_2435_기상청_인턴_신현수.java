package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_2435_기상청_인턴_신현수 {

    static int N, K;

    static int[] temperature;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temperature = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            temperature[i] = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;

        for(int i=0; i<N-K+1; i++) {
            int partSum = 0;

            for(int j=i; j<i+K; j++)
                partSum += temperature[j];

            max = Math.max(max, partSum);
        }

        System.out.println(max);
    }
}
