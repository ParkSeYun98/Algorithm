package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_1522_문자열_교환 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int aCnt = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == 'a')
                aCnt++;
        }

        for(int i=0; i<input.length(); i++) {
            int bCnt = 0;

            for(int j=i; j<aCnt+i; j++) {
                if(input.charAt(j % input.length()) == 'b')
                    bCnt++;
            }

            min = Math.min(min, bCnt);
        }

        System.out.println(min);
    }
}
