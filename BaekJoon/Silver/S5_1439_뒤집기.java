package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();

        int zeroCnt = 0;
        int oneCnt = 0;

        if(input.charAt(input.length()-1) == '1')
            zeroCnt++;
        else
            oneCnt++;

        for(int i=0; i<input.length()-1; i++) {
            if(input.charAt(i) == '0' && input.charAt(i+1) == '1')
                oneCnt++;
            else if(input.charAt(i) == '1' && input.charAt(i+1) == '0')
                zeroCnt++;
        }

        System.out.println(Math.min(zeroCnt, oneCnt));
    }
}
