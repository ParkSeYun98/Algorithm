package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_26007_Codepowers {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];

        arr[0] = X;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());

            if(arr[i] < K)
                sum[i] = sum[i-1] + 1;
            else
                sum[i] = sum[i-1];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(arr[l] < K)
                sb.append(sum[r-1] - sum[l] + 1);
            else
                sb.append(sum[r-1] - sum[l]);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
