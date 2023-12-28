/*
* Memory : 11496 KB
* Time : 80 ms
* */

package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_1919_애너그램_만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strA = br.readLine();
        String strB = br.readLine();

        int[] countA = new int[26];
        int[] countB = new int[26];

        for(int i=0; i<strA.length(); i++)
            countA[strA.charAt(i)-'a']++;

        for(int i=0; i<strB.length(); i++)
            countB[strB.charAt(i)-'a']++;

        int cnt = 0;

        for(int i=0; i<26; i++)
            cnt += Math.abs(countA[i] - countB[i]);

        System.out.println(cnt);
    }
}
