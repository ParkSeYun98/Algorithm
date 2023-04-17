package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2166_다각형의_면적 {
    static int N;

    static long[] X;
    static long[] Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        X = new long[N+1];
        Y = new long[N+1];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(String.format("%.1f", Math.abs(shoelace())));
    }

    static double shoelace() {
        long partSum1 = 0;
        long partSum2 = 0;

        X[N] = X[0];
        Y[N] = Y[0];

        for(int i=0; i<N; i++) {
            partSum1 += X[i]*Y[i+1];
            partSum2 += X[i+1]*Y[i];
        }

        return 0.5 * (partSum1 - partSum2);
    }
}
