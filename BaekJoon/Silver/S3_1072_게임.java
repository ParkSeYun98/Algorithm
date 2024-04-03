package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1072_게임 {

    static long X, Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int Z = (int) (100 * Y / X);

        if(Z >= 99) {
            System.out.println(-1);
            return;
        }

        int left = 0;
        int right = 1_000_000_000;
        int cnt = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            int nowZ = (int) (((Y + mid) * 100) / (X + mid));

            if(Z >= nowZ) {
                left = mid + 1;
                cnt = mid + 1;
            }
            else
                right = mid - 1;
        }

        System.out.println(cnt);
    }
}
