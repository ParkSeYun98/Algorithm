package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1_1357_뒤집힌_덧셈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        System.out.println(Rev(Rev(X) + Rev(Y)));
    }

    static int Rev(int num) {
        Queue<Integer> queue = new LinkedList<>();

        while(num > 0) {
            queue.offer(num % 10);
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty())
            sb.append(queue.poll());

        return Integer.parseInt(sb.toString());
    }
}
