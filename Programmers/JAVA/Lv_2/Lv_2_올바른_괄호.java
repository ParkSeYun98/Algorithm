package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_올바른_괄호 {
    class Solution {
        boolean solution(String s) {
            boolean answer = true;

            Stack<Character> stack = new Stack<>();

            if(s.charAt(0) == ')')
                return false;

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '(')
                    stack.push(s.charAt(i));
                else {
                    if(stack.size() == 0)
                        return false;
                    else
                        stack.pop();
                }
            }

            if(stack.size() == 0)
                answer = true;
            else
                answer = false;

            return answer;
        }
    }
}
