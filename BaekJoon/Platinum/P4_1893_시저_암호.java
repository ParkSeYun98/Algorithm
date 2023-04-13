package BaekJoon.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P4_1893_시저_암호 {
    static String A;
    static String W;
    static String S;
    static int cnt;

    static Map<Character, Integer> map1;
    static Map<Integer, Character> map2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=N; tc++) {
            A = br.readLine();
            W = br.readLine();
            S = br.readLine();

            map1 = new HashMap<>();
            map2 = new HashMap<>();

            cnt = 0;

            for(int i=0; i<A.length(); i++) {
                map1.put(A.charAt(i), i);
                map2.put(i, A.charAt(i));
            }

            StringBuilder result = new StringBuilder();

            for(int i=0; i<A.length(); i++) {
                StringBuilder sb = new StringBuilder();

                for(int j=0; j<S.length(); j++) {
                    int idx = map1.get(S.charAt(j));

                    idx -= i;

                    if(idx<0)
                        idx += A.length();

                    sb.append(map2.get(idx));
                }

                cnt = 0;
                KMP(sb.toString());

                if(cnt == 1)
                    result.append(i).append(" ");
            }

            if(result.length() == 0)
                System.out.println("no solution");
            else if(result.length() == 2)
                System.out.println("unique: " + result);
            else
                System.out.println("ambiguous: " + result);
        }
    }

    static int[] getTable() {
        int idx = 0;
        int[] table = new int[W.length()];

        for(int i=1; i<table.length; i++) {
            while(idx>0 && W.charAt(i) != W.charAt(idx))
                idx = table[idx-1];

            if(W.charAt(i) == W.charAt(idx))
                table[i] = ++idx;
        }

        return table;
    }

    static void KMP(String original) {
        int idx = 0;
        int[] table = getTable();

        for(int i=0; i<original.length(); i++) {
            while(idx>0 && original.charAt(i) != W.charAt(idx))
                idx = table[idx-1];

            if(original.charAt(i) == W.charAt(idx)) {
                if(idx == W.length()-1) {
                    cnt++;
                    idx = table[idx];
                }
                else
                    idx++;
            }
        }
    }
}
