package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2230_수_고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] A = new long[N+1];

        for(int i=0; i<N; i++)
            A[i+1] = Long.parseLong(br.readLine());

        Arrays.sort(A);

        int start = 1;
        int end = 1;
        long min = Long.MAX_VALUE;

        while(true) {
            if(end > N)
                break;

            long diff = Math.abs(A[start] - A[end]);

            if(diff < M)
                end++;
            else if(diff == M) {
                min = diff;
                break;
            }
            else {
                min = Math.min(min, diff);
                start++;
            }
        }

        System.out.println(min);
    }
}
