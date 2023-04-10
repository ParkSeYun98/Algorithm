package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_16172_나는_친구가_적다_Large {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String K = br.readLine();

        StringBuilder newS = new StringBuilder();

        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) - '0' > 9)
                newS.append(S.charAt(i));
        }

        KMP(newS.toString(), K);
    }

    static int[] makeTable(String K) {
        int idx = 0;
        int[] table = new int[K.length()];

        for(int i=1; i<K.length(); i++) {
            while(idx>0 && K.charAt(i) != K.charAt(idx))
                idx = table[idx-1];

            if(K.charAt(i) == K.charAt(idx)) {
                idx+=1;
                table[i] = idx;
            }
        }

        return table;
    }

    static void KMP(String newS, String K) {
        int idx = 0;
        int[] table = makeTable(K);

        for(int i=0; i<newS.length(); i++) {
            while(idx>0 && newS.charAt(i) != K.charAt(idx))
                idx = table[idx-1];

            if(newS.charAt(i) == K.charAt(idx)) {
                if(idx == K.length()-1) {
                    System.out.println(1);
                    return;
                }
                else
                    idx+=1;
            }
        }

        System.out.println(0);
    }
}
