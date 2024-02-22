/*
* Memory : 51496 KB
* Time : 268 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_30804_과일_탕후루 {

    static int N;

    static int[] tanghuru;
    static int[] cntArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tanghuru = new int[N];
        cntArr = new int[10];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            tanghuru[i] = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append(reduceFruit(0, 0, 0, 0, 0));

        System.out.println(sb);
    }

    static int reduceFruit(int left, int right, int cnt, int kind, int max) {
        if (right >= N)
            return max;

        if (cntArr[tanghuru[right]] == 0)
            kind++;

        cnt++;
        cntArr[tanghuru[right]]++;

        if (kind > 2) {
            if (--cntArr[tanghuru[left]] == 0)
                kind--;

            cnt--;
            left++;
        }

        max = Math.max(max, cnt);

        return reduceFruit(left, right + 1, cnt, kind, max);
    }
}
