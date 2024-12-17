package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4_10808_알파벳_개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];

        String S = br.readLine();

        for(int i=0; i<S.length(); i++)
            arr[S.charAt(i) - 'a']++;

        for (int now : arr)
            System.out.print(now + " ");
    }
}
