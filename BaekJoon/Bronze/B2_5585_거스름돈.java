package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2_5585_거스름돈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());

        int num = 1000 - price;

        int cnt = 0;

        while (num != 0) {
            if (num / 500 != 0) {
                cnt += num / 500;
                num %= 500;
            } else if (num / 100 != 0) {
                cnt += num / 100;
                num %= 100;
            } else if (num / 50 != 0) {
                cnt += num / 50;
                num %= 50;
            } else if (num / 10 != 0) {
                cnt += num / 10;
                num %= 10;
            } else if (num / 5 != 0) {
                cnt += num / 5;
                num %= 5;
            } else if (num / 1 != 0) {
                cnt += num / 1;
                num %= 1;
            }
        }

        System.out.println(cnt);
    }
}
