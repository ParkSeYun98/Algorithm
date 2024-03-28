/*
* Memory : 17004 KB
* Time : 160 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_20300_서강근육맨 {

    static int N;

    static long[] gymArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        gymArr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            gymArr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(gymArr);

        long minM = -1;

        if(N%2 == 1) {
            for(int i=0; i<N/2; i++)
                minM = Math.max(minM, gymArr[i] + gymArr[N-2-i]);

            minM = Math.max(minM, gymArr[N-1]);
        }
        else {
            for(int i=0; i<N/2; i++)
                minM = Math.max(minM, gymArr[i] + gymArr[N-1-i]);
        }

        System.out.println(minM);
    }
}
