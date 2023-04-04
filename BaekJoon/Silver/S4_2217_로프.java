package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[N];

        for(int i=0; i<N; i++)
            weight[i] = Integer.parseInt(br.readLine());

        Arrays.sort(weight);

        int max = -1;
        int idx = 0;

        while(N > idx) {
            max = Math.max(max, weight[idx] * (N-idx));
            idx++;
        }

        System.out.println(max);
    }
}
