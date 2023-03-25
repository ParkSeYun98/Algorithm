package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11728_배열_합치기 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arrA = new int[N];
        int[] arrB = new int[M];
        int[] result = new int[N+M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arrA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++)
            arrB[i] = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;
        int idx = 0;
        while(i<N && j<M) {
            if(arrA[i] < arrB[j])
                result[idx++] = arrA[i++];
            else
                result[idx++] = arrB[j++];
        }

        if(i < N) {
            for(int k=i; k<N; k++)
                result[idx++] = arrA[k];
        }
        else if(j < M) {
            for(int k=j; k<M; k++)
                result[idx++] = arrB[k];
        }

        StringBuilder sb = new StringBuilder();

        for(int k=0; k<result.length; k++)
            sb.append(result[k] + " ");

        System.out.println(sb.toString());
    }
}
