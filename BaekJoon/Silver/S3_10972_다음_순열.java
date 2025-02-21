package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_10972_다음_순열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int[] target = new int[N];

        for(int i=0; i<N; i++)
            target[i] = Integer.parseInt(st.nextToken());

        nextPermutation(N, target);
    }

    static void nextPermutation(int N, int[] target) {
        int idx = N-1;
        int idx2 = N-1;

        while((idx>0) && (target[idx-1]>=target[idx]))
            idx--;

        if(idx <= 0) {
            System.out.println(-1);
            return;
        }

        while(target[idx-1] >= target[idx2])
            idx2--;

        swap(target, idx, idx2);

        idx2 = N-1;
        int temp = 0;

        while(idx < idx2) {
            temp = target[idx];
            target[idx] = target[idx2];
            target[idx2] = temp;
            idx++;
            idx2--;
        }

        for (int now : target)
            System.out.print(now + " ");
    }

    static void swap(int[] target, int idx, int idx2) {
        int temp = target[idx-1];
        target[idx-1] = target[idx2];
        target[idx2] = temp;
    }
}
