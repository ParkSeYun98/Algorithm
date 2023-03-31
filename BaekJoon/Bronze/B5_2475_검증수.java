package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B5_2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = new int[5];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<5; i++)
            input[i] = Integer.parseInt(st.nextToken());

        int sum = 0;

        for(int i=0; i<input.length; i++)
            sum += Math.pow(input[i], 2);

        System.out.println(sum % 10);
    }
}
