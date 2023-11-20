/*
* Memory: 14260 KB
* Time: 116 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_2003_수들의_합_2 {

    private static int N;
    private static int M;
    private static int cnt = 0;
    private static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        getSum();

        System.out.println(cnt);
    }

    public static void getSum() {
        int start = 0;
        int end = 0;
        int partSum = 0;

        while(true) {
            if(end >= A.length)
                break;

            if(partSum + A[end] < M) {
                partSum += A[end++];
            }
            else if(partSum + A[end] > M) {
                end = ++start;
                partSum = 0;
            }
            else {
                start++;
                end = start;
                cnt++;
                partSum = 0;
            }
        }
    }
}
