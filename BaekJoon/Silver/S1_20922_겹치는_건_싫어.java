package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_20922_겹치는_건_싫어 {

    static int N, K, max;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        getLongest();
    }

    static void getLongest() {
        int start = 0;
        int end = 0;
        int[] numArr = new int[100001];

        while(true) {
            if(end >= N)
                break;

            while(true) {
                if(end >= N)
                    break;

                if(numArr[arr[end]] >= K)
                    break;

                numArr[arr[end++]]++;
            }

            max = Math.max(max, end-start);
            numArr[arr[start++]]--;
        }

        System.out.println(max);
    }
}
