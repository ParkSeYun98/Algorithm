package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_3986_좋은_단어 {

    static int N;

    static String[] voca;

    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        voca = new String[N];

        for(int i=0; i<N; i++)
            voca[i] = br.readLine();

        int cnt = 0;

        for (String str : voca) {
            stack = new Stack<>();

            for(int i=0; i<str.length(); i++) {
                char now = str.charAt(i);

                if(stack.isEmpty() || stack.peek() != now)
                    stack.push(now);
                else
                    stack.pop();
            }

            if(stack.isEmpty())
                cnt++;
        }

        System.out.println(cnt);
    }
}
