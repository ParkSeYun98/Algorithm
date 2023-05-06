package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4_2440_별_찍기_3 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        printStar();
    }

    static void printStar() {
        for(int i=0; i<N; i++) {
            for(int j=N-i; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
