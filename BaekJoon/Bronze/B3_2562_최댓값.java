package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3_2562_최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int idx = -1;

        for(int i=0; i<9; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if(max < tmp) {
                max = tmp;
                idx = i+1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
