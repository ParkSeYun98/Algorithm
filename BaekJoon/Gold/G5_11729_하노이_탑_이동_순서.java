/*
* Memory : 44884 KB
* Time : 328 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_11729_하노이_탑_이동_순서 {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        sb.append((int)(Math.pow(2, N) - 1)).append("\n");

        moveHanoi(N, 1, 2, 3);

        System.out.println(sb.toString());
    }

    public static void moveHanoi(int amount, int start, int mid, int to) {
        if(amount == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        moveHanoi(amount-1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        moveHanoi(amount-1, mid, start, to);
    }
}
