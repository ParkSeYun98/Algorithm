package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_12847_꿀_아르바이트 {

    static int n, m;

    static int[] T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        T = new int[n];

        for(int i=0; i<n; i++)
            T[i] = Integer.parseInt(st.nextToken());

        long sum = 0;

        for(int i=0; i<m; i++)
            sum += T[i];

        long max = sum;

        for(int i=m; i<n; i++) {
            sum += T[i];
            sum -= T[i-m];

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
