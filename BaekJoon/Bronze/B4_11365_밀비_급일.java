package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4_11365_밀비_급일 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while(!(input = br.readLine()).equals("END")) {
            StringBuilder sb = new StringBuilder();

            sb.append(input);
            sb.reverse();
            System.out.println(sb);
        }
    }
}
