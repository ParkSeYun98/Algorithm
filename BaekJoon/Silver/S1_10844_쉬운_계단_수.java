package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_10844_쉬운_계단_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // null값을 활용하기 위해 래퍼클래스 사용
        Long[][] dp = new Long[N+1][10];

        Arrays.fill(dp[0], 0L);
        Arrays.fill(dp[1], 1L);

        long result = 0L;

        for(int i=1; i<=9; i++)
            result += Recursive(dp, N, i);

        System.out.println(result % 1_000_000_000);
    }

    static Long Recursive(Long[][] dp, int digit, int value) {
        if(digit == 1)
            return dp[digit][value];

        if(dp[digit][value] == null) {
            if(value == 0)
                dp[digit][value] = Recursive(dp, digit-1, 1);
            else if(value == 9)
                dp[digit][value] = Recursive(dp, digit-1, 8);
            else
                dp[digit][value] = Recursive(dp, digit-1, value-1) + Recursive(dp, digit-1, value+1);
        }

        return dp[digit][value] % 1_000_000_000;
    }
}
