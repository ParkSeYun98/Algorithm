package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3_2720_세탁소_사장_동혁 {

    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            C = Integer.parseInt(br.readLine());

            program();
        }
    }

    static void program() {
        int Quarter = 0;
        int Dime = 0;
        int Nickel = 0;
        int Penny = 0;

        while(C > 0) {
            if(C >= 25) {
                Quarter += C/25;
                C %= 25;
            }
            else if(C >= 10) {
                Dime += C/10;
                C %= 10;
            }
            else if(C >= 5) {
                Nickel += C/5;
                C %= 5;
            }
            else {
                Penny += C/1;
                C %= 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Quarter).append(' ').append(Dime).append(' ').append(Nickel).append(' ').append(Penny);

        System.out.println(sb);
    }
}
