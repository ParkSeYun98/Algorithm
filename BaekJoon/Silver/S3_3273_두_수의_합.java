/*
* Memory : 26184 KB
* Time : 316 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_3273_두_수의_합 {

    static int n;
    static int x;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        x = Integer.parseInt(br.readLine());

        Solve();
    }

    static void Solve() {
        Arrays.sort(arr);

        int cnt = 0;
        int start = 0;
        int end = n-1;

        while(start < end) {
            int sum = arr[start] + arr[end];

            if(sum > x)
                end--;
            else if(sum < x)
                start++;
            else {
                cnt++;
                start++;
                end--;
            }
        }

        System.out.println(cnt);
    }
}
