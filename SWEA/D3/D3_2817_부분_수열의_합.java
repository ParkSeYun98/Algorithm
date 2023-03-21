package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_2817_부분_수열의_합 {
    private static int N;
    private static int K;
    private static int result;

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            result = 0;

            solve(0, 0, 0);

            System.out.println("#" + tc + " " + result);
        }
    }

    public static void solve(int depth, int idx, int partSum) {
        if(partSum == K) {
            result++;
            return;
        }

        if(depth == N) {
            return;
        }

        solve(depth+1, idx+1, partSum+arr[idx]);
        solve(depth+1, idx+1, partSum);
    }
}