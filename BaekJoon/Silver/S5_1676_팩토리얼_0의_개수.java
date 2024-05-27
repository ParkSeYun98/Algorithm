package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_1676_팩토리얼_0의_개수 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int twoCnt = 0;
        int fiveCnt = 0;

        while(N > 0) {
            int now = N;

            while(now > 0) {
                if(now % 2 == 0) {
                    twoCnt++;
                    now /= 2;
                    continue;
                }

                if(now % 5 == 0) {
                    fiveCnt++;
                    now /= 5;
                    continue;
                }

                break;
            }

            N--;
        }

        System.out.println(Math.min(twoCnt, fiveCnt));
    }
}
