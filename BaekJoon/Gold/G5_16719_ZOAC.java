package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_16719_ZOAC {

    static String input;

    static StringBuilder sb;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        sb = new StringBuilder();
        visited = new boolean[input.length()];

        recur(0, input.length()-1);

        System.out.println(sb);
    }

    static void recur(int left, int right) {
        if (left > right)
            return;

        int idx = left;

        for (int i = left; i <= right; i++) {
            if (input.charAt(idx) > input.charAt(i))
                idx = i;
        }

        visited[idx] = true;

        for (int i = 0; i < input.length(); i++) {
            if (visited[i])
                sb.append(input.charAt(i));
        }
        sb.append("\n");

        recur(idx + 1, right);
        recur(left, idx  - 1);
    }
}
