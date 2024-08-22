package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_괄호_회전하기 {

    public int solution(String s) {
        int cnt = 0;

        for(int i=0; i<s.length(); i++) {
            Stack<Character> stack = new Stack<>();

            for(int j=0; j<s.length(); j++) {
                if(stack.isEmpty())
                    stack.push(s.charAt(j));
                else {
                    if(s.charAt(j) == ']' && stack.peek() == '[')
                        stack.pop();
                    else if(s.charAt(j) == '}' && stack.peek() == '{')
                        stack.pop();
                    else if(s.charAt(j) == ')' && stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(s.charAt(j));
                }
            }

            if(stack.isEmpty())
                cnt++;

            String temp = s.substring(1, s.length()) + s.substring(0, 1);

            s = temp;
        }

        return cnt;
    }
}
