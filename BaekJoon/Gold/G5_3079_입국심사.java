package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_3079_입국심사 {

    static int N, M, max;

    static int[] T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        T = new int[N];

        max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            T[i] = Integer.parseInt(br.readLine());
            max = Math.max(T[i], max);
        }

        BinarySearch();
    }

    static void BinarySearch() {
        long left = 0L;
        long right = (long) max * M;
        long answer = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for(int i=0; i<N; i++) {
                long temp = (mid / T[i]);

                if (sum >= M)
                    break;

                sum += temp;
            }

            if(sum >= M) {
                right = mid - 1;
                answer = Math.min(mid, answer);
            }
            else
                left = mid + 1;
        }

        System.out.println(answer);
    }
}
