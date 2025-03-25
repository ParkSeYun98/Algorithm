package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2004_조합_0의_개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long fiveCnt = getFive(n) - getFive(n-m) - getFive(m);
        long twoCnt = getTwo(n) - getTwo(n-m) - getTwo(m);

        System.out.println(Math.min(fiveCnt, twoCnt));
    }

    static long getTwo(long num) {
        long cnt = 0;

        while(num >= 2) {
            cnt += (num/2);
            num /= 2;
        }

        return cnt;
    }

    static long getFive(long num) {
        long cnt = 0;

        while(num >= 5) {
            cnt += (num/5);
            num /= 5;
        }

        return cnt;
    }
}
