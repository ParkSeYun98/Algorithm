package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G3_2812_크게_만들기 {

    static int N, K;

    static char[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new char[N];

        num = br.readLine().toCharArray();

        makeBigNum();
    }

    static void makeBigNum() {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for(int i=0; i<N; i++) {
            int now = num[i] - '0';

            if(stack.isEmpty())
                stack.push(now);
            else {
                while(!stack.isEmpty()) {
                    if((stack.peek() < now) && (cnt < K)) {
                        stack.pop();
                        cnt++;
                    }
                    else
                        break;
                }

                stack.push(now);
            }
        }

        while (cnt < K) {
            stack.pop();
            cnt++;
        }

        for (Integer i : stack)
            System.out.print(i);
    }
}
