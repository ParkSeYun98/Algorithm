package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_4563_리벤지_오브_피타고라스 {
    private static long A;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            A = Integer.parseInt(br.readLine());

            if(A == 0)
                System.exit(0);

            cnt = 0;

            check();

            System.out.println(cnt);
        }
    }

    public static void check() {
        long K = A*A;

        for(int i=1; i<=A; i++) {
            if(K % i == 0) {
                if((K/i + i) % 2 == 0 && (K/i - i) % 2 == 0 && (K/i - i)/2 > A)
                    cnt++;
            }
        }
    }
}