package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1789_수들의_합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int idx = 1;
        int cnt = 0;

        while(true) {
            if(sum > S)
                break;
            else {
                sum += idx++;
                cnt++;
            }
        }

        System.out.println(cnt - 1);
    }
}
