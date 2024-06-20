package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1747_소수_팰린드롬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(2);
            return;
        }

        while(true) {
            if(palindromeCheck(N) && primeCheck(N)) {
                System.out.println(N);
                break;
            }

            N++;
        }
    }

    static boolean palindromeCheck(int num) {
        String str = Integer.toString(num);

        for(int i=0; i<=str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }

        return true;
    }

    static boolean primeCheck(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0)
                return false;
        }

        return true;
    }
}
