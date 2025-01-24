package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_15810_풍선_공장 {

    static int N, M;

    static int[] balloon, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        balloon = new int[N];
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());
            balloon[i] = now;
            min = Math.min(min, now);
        }

        BinarySearch(min);
    }

    static void BinarySearch(int min) {
        long left = 0;
        long right = (long) min * M;

        while(left <= right) {
            long mid = (left+right) / 2;
            long cnt = 0;

            for(int i=0; i<N; i++)
                cnt += mid/balloon[i];

            if(cnt >= M)
                right = mid - 1;
            else
                left = mid + 1;
        }

        System.out.println(left);
    }
}
