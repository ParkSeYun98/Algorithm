package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class G5_2493_탑 {

    static class Top {
        int idx;
        int height;

        public Top(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int idx = 0;
        int[] answer = new int[N];
        Stack<Top> stack = new Stack<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++) {
            int now = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                answer[idx++] = 0;
                stack.push(new Top(i, now));
            }
            else {
                while(true) {
                    if(stack.isEmpty()) {
                        answer[idx++] = 0;
                        stack.push(new Top(i, now));
                        break;
                    }

                    Top top = stack.peek();

                    if(top.height > now) {
                        answer[idx++] = top.idx;
                        stack.push(new Top(i, now));
                        break;
                    }
                    else
                        stack.pop();
                }
            }
        }

        for (int i : answer)
            System.out.print(i + " ");
    }
}
