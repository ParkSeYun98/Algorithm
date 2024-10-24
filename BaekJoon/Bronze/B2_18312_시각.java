package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_18312_시각 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int h=0; h<=N; h++) {
            for(int m=0; m<60; m++) {
                for(int s=0; s<60; s++) {
                    if(h%10==K || h/10==K|| m%10==K || m/10==K || s%10==K || s/10==K)
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
