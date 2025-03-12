package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_17390_이건_꼭_풀어야_해 {

    static int N, Q;

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         st = new StringTokenizer(br.readLine(), " ");
         N = Integer.parseInt(st.nextToken());
         Q = Integer.parseInt(st.nextToken());

         A = new int[N+1];

         st = new StringTokenizer(br.readLine(), " ");
         for(int i=1; i<=N; i++)
             A[i] = Integer.parseInt(st.nextToken());

         Arrays.sort(A);

         for(int i=1; i<A.length; i++)
             A[i] += A[i-1];

         StringBuilder sb = new StringBuilder();

         for(int i=0; i<Q; i++) {
             st = new StringTokenizer(br.readLine(), " ");
             int L = Integer.parseInt(st.nextToken());
             int R = Integer.parseInt(st.nextToken());

             sb.append(A[R] - A[L-1]).append('\n');
         }

        System.out.println(sb);
    }
}
