package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_2622_삼각형만들기 {

    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cnt = 0;

        for(int i=1; i<N; i++) {
            for(int j=i; j<N; j++) {
                int k = N-i-j;

                if(k<=0 || i>k || j>k)
                    continue;

                if(i+j > k)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
