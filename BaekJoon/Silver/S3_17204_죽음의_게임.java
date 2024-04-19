package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_17204_죽음의_게임 {

    static int N, K;

    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];

        for(int i=0; i<N; i++)
            num[i] = Integer.parseInt(br.readLine());

        int cnt = 1;
        int idx = 0;

        while(true) {
            if(num[idx] == K)
                break;

            idx = num[idx];

            if(N < cnt)
                break;

            cnt++;
        }

        if(cnt > N)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }
}
