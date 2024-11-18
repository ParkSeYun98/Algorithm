package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_18511_큰_수_구성하기 {

    static int N, K, max;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<K; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        max = Integer.MIN_VALUE;

        makeBiggestNumber(0);

        System.out.println(max);
    }

    static void makeBiggestNumber(int now) {
        if(now > N)
            return;

        max = Math.max(max, now);

        for(int i=K-1; i>=0; i--)
            makeBiggestNumber(now*10 + arr[i]);
    }
}
