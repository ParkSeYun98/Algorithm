package BaekJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5_1786_찾기 {
    static int cnt = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        KMP(T, P);

        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    static int[] getTable(String P) {
        int idx = 0;
        int[] table = new int[P.length()];

        for(int i=1; i<P.length(); i++) {
            while(idx>0 && P.charAt(i) != P.charAt(idx))
                idx = table[idx-1];

            if(P.charAt(i) == P.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }

        return table;
    }

    static void KMP(String T, String P) {
        int idx = 0;
        int[] table = getTable(P);

        for(int i=0; i<T.length(); i++) {
            while(idx>0 && P.charAt(idx) != T.charAt(i))
                idx = table[idx-1];

            if(P.charAt(idx) == T.charAt(i)) {
                if(idx == P.length()-1) {
                    cnt++;
                    sb.append(i-idx+1).append(' ');
                    idx = table[idx];
                }
                else
                    idx++;
            }
        }
    }
}
