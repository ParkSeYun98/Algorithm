package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1074_Z {
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int length = (int)Math.pow(2, N);

        divide(r, c, length);

        System.out.println(cnt);
    }

    public static void divide(int r, int c, int length) {
        if(length == 1)
            return;

        int nextLength = length/2;

        if(r < nextLength && c < nextLength)
            divide(r, c, nextLength);
        else if(r < nextLength && c >= nextLength) {
            cnt += (int)Math.pow(nextLength, 2);
            divide(r, c-nextLength, nextLength);
        }
        else if(r >= nextLength && c < nextLength) {
            cnt += (int)Math.pow(nextLength, 2) * 2;
            divide(r-nextLength, c, nextLength);
        }
        else {
            cnt += (int)Math.pow(nextLength, 2) * 3;
            divide(r-nextLength, c-nextLength, nextLength);
        }
    }
}
