package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S4_1026_보물 {
    private static int N;

    private static int[] A;
    private static Integer[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N];
        B = new Integer[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;

        for(int i=0; i<N; i++)
            result += A[i] * B[i];

        System.out.println(result);
    }
}
