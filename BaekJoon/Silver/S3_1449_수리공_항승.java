package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_1449_수리공_항승 {

    static int N, L, min, range;

    static int[] leak;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        leak = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            leak[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(leak);

        min = 1;
        range = leak[0] + L;

        for(int i=1; i<leak.length; i++) {
            if(range < leak[i] + 0.5) {
                range = leak[i] + L;
                min++;
            }
        }

        System.out.println(min);
    }
}
