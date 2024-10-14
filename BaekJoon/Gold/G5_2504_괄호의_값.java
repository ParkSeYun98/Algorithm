package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class G5_2504_괄호의_값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int score = 0;
        int temp = 1;
        boolean flag = true;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            char now = input.charAt(i);

            if(now == '(') {
                stack.push(now);
                temp *= 2;
            }
            else if(now == '[') {
                stack.push(now);
                temp *= 3;
            }
            else if(now == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                else if(input.charAt(i-1) == '(')
                    score += temp;

                stack.pop();
                temp /= 2;
            }
            else if(now == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                else if(input.charAt(i-1) == '[')
                    score += temp;

                stack.pop();
                temp /= 3;
            }
        }

        if(flag && stack.isEmpty())
            System.out.println(score);
        else
            System.out.println(0);
    }
}
