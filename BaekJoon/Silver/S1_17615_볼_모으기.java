/*
* Memory : 18636 KB
* Time : 180 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_17615_볼_모으기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        int min = Integer.MAX_VALUE;
        int rCnt = 0;
        int bCnt = 0;

        for(int i=0; i<N; i++) {
            if(input.charAt(i) == 'R')
                rCnt++;
            else
                bCnt++;
        }

        for(int i=0; i<N; i++) {
            if(input.charAt(i) == 'R')
                cnt++;
            else
                break;
        }

        min = Math.min(min, rCnt - cnt);
        cnt = 0;

        for(int i=0; i<N; i++) {
            if(input.charAt(i) == 'B')
                cnt++;
            else
                break;
        }

        min = Math.min(min, bCnt - cnt);
        cnt = 0;

        for(int i=N-1; i>=0; i--) {
            if(input.charAt(i) == 'R')
                cnt++;
            else
                break;
        }

        min = Math.min(min, rCnt - cnt);
        cnt = 0;

        for(int i=N-1; i>=0; i--) {
            if(input.charAt(i) == 'B')
                cnt++;
            else
                break;
        }

        min = Math.min(min, bCnt - cnt);
        System.out.println(min);
    }
}
