package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_16916_부분_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        KMP(S, P);
    }

    static int[] makeTable(String pattern) {
        int[] table = new int[pattern.length()];
        int idx = 0;

        for(int i=1; i<pattern.length(); i++) {
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx))
                idx = table[idx-1];

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }

        return table;
    }

    static void KMP(String str, String pattern) {
        int[] table = makeTable(pattern);
        int idx = 0;

        for(int i=0; i<str.length(); i++) {
            while(idx>0 && str.charAt(i) != pattern.charAt(idx))
                idx = table[idx-1];

            if(str.charAt(i) == pattern.charAt(idx)) {
                if(idx == pattern.length()-1) {
                    System.out.println(1);
                    return;
                }
                else
                    idx += 1;
            }
        }

        System.out.println(0);
    }
}
