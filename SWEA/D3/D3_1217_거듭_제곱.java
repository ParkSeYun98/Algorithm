package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1217_거듭_제곱 {
    private static int N;
    private static int M;
    private static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc=1; tc<=10; tc++) {
            int T = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            result = 0;
            Recursive(1, N);

            System.out.println("#" + T + " " + result);
        }

    }

    public static void Recursive(int depth, int target) {
        if(depth == M) {
            result = (long) target;
            return;
        }

        Recursive(depth+1, target * N);
    }
}
