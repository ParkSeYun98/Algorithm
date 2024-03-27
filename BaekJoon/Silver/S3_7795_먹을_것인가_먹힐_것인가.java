/*
* Memory : 38684 KB
* Time : 388 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_7795_먹을_것인가_먹힐_것인가 {

    static int N, M;

    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++)
                B[i] = Integer.parseInt(st.nextToken());

            eat();
        }
    }

    static void eat() {
        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;

        for(int i=0; i<N; i++) {
            int start = 0;
            int end = M - 1;
            int idx = 0;

            while(start <= end) {
                int mid = (start + end) / 2;

                if(B[mid] < A[i]) {
                    start = mid + 1;
                    idx = mid + 1;
                }
                else
                    end = mid - 1;
            }

            cnt += idx;
        }

        System.out.println(cnt);
    }
}
