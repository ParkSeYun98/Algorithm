package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1193_분수찾기 {

    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());

        int line = 1;
        int sum = 0;

        while(true) {
            if(X <= (line + sum)) {
                if((line % 2) == 0) {
                    System.out.println((X - sum) + "/" + (line - (X - sum - 1)));
                }
                else
                    System.out.println((line - (X - sum - 1)) + "/" + (X - sum));

                break;
            }
            else {
                sum += line;
                line++;
            }
        }
    }
}
