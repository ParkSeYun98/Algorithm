package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_20444_색종이와_가위 {

    static long n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        cut();
    }

    static void cut() {
        long left = 0;
        long right = n;

        while(left <= right) {
            long r = (left + right) / 2;
            long c = n - r;
            long sum = (r+1) * (c+1);

            if(sum == k) {
                System.out.println("YES");
                return;
            }
            else if(sum > k)
                right = r - 1;
            else
                left = r + 1;
        }

        System.out.println("NO");
    }
}
