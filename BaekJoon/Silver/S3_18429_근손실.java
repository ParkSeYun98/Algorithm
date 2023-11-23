/*
* Memory : 11748 KB
* Time : 92 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_18429_근손실 {

    private static int N;
    private static int K;
    private static int cnt = 0;

    private static int[] A;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        exercise(0, 500);

        System.out.println(cnt);
    }

    public static void exercise(int depth, int weight) {
        if(depth == N) {
            cnt++;
            return;
        }

        for(int i=0; i<N; i++) {
            int nextWeight = weight - K + A[i];

            if(!visited[i] && nextWeight >= 500) {
                visited[i] = true;
                exercise(depth + 1, nextWeight);
                visited[i] = false;
            }
        }
    }
}
