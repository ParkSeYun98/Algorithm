package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4_2439_별_찍기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            for(int j=N-i-2; j>=0; j--)
                System.out.print(" ");

            for(int j=0; j<=i; j++)
                System.out.print("*");

            System.out.println();
        }
    }
}
