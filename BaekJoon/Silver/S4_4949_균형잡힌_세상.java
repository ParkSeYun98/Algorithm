package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class S4_4949_균형잡힌_세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while(!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean flag = false;

            for(int i=0; i<input.length(); i++) {
                char temp = input.charAt(i);

                if(temp == '(')
                    stack.push(temp);
                else if(temp == '[')
                    stack.push(temp);
                else if(temp == ')') {
                    if(stack.isEmpty() || stack.peek() == '[') {
                        System.out.println("no");
                        flag = true;
                        break;
                    }
                    else
                        stack.pop();
                }
                else if(temp == ']') {
                    if(stack.isEmpty() || stack.peek() == '(') {
                        System.out.println("no");
                        flag = true;
                        break;
                    }
                    else
                        stack.pop();
                }
            }

            if(flag)
                continue;

            if(stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
