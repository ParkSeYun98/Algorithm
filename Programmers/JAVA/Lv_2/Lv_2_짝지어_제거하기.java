package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_짝지어_제거하기 {

    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char now = s.charAt(i);

            if(stack.isEmpty())
                stack.push(now);
            else {
                if(stack.peek() == now)
                    stack.pop();
                else
                    stack.push(now);
            }
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
