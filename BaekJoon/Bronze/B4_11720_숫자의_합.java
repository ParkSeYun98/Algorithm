package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4_11720_숫자의_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for(int i=0; i<input.length(); i++)
            sum += (input.charAt(i) - '0');

        System.out.println(sum);
    }
}
