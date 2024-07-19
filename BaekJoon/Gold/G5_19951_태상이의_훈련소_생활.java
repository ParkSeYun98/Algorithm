package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_19951_태상이의_훈련소_생활 {

    static int N, M;

    static int[] height, partSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() ," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        height = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            height[i+1] = Integer.parseInt(st.nextToken());

        partSum = new int[N+2];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            partSum[a] += k;
            partSum[b+1] += (-k);
        }

        for(int i=1; i<=N; i++)
            partSum[i] += partSum[i-1];

        for(int i=1; i<=N; i++)
            height[i] += partSum[i];

        for(int i=1; i<=N; i++)
            System.out.print(height[i] + " ");
    }
}
