package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5_27866_문자와_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String voca = br.readLine();

        int idx = Integer.parseInt(br.readLine());

        System.out.println(voca.charAt(idx-1));
    }
}
