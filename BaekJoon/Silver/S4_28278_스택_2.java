package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S4_28278_스택_2 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int order = Integer.parseInt(st.nextToken());

            switch(order) {
                case 1:
                    int X = Integer.parseInt(st.nextToken());
                    stack.push(X);
                    break;
                case 2:
                    if(stack.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.pop()).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    if(stack.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;
                case 5:
                    if(stack.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.peek()).append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}
