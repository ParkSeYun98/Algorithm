package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_2231_분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            int sum = 0;
            String temp = String.valueOf(i);

            for(int j=0; j<temp.length(); j++) {
                char now = temp.charAt(j);

                sum += (now - '0');
            }

            sum += i;

            if(sum == N) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
    }
}
