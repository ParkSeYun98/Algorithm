/*
* Memory : 12432 KB
* Time : 92 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_2661_좋은수열 {

    static final int START = 1;
    static final int END = 3;

    static int N, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;

        getSeries("");
    }

    static void getSeries(String str) {
        if(str.length() == N) {
            System.out.println(str);

            System.exit(0);
        }

        for(int i=START; i<=END; i++) {
            if(goodSeriesCheck(str + i))
                getSeries(str + i);
        }
    }

    static boolean goodSeriesCheck(String fullStr) {
        int fullLen = fullStr.length();

        for(int i=1; i<=fullLen/2; i++) {
            String partStrA = fullStr.substring(fullLen - 2*i, fullLen - i);
            String partStrB = fullStr.substring(fullLen - i, fullLen);

            if(partStrA.equals(partStrB))
                return false;
        }

        return true;
    }
}
