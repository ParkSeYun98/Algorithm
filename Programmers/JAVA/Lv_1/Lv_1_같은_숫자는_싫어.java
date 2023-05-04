package Programmers.JAVA.Lv_1;

import java.util.*;

public class Lv_1_같은_숫자는_싫어 {
    public class Solution {
        public int[] solution(int []arr) {
            int[] answer = {};

            Stack<Integer> stack = new Stack<>();

            for(int i=0; i<arr.length; i++) {
                if(stack.size() == 0)
                    stack.push(arr[i]);
                else {
                    if(stack.peek() != arr[i])
                        stack.push(arr[i]);
                }
            }

            answer = new int[stack.size()];

            while(!stack.isEmpty())
                answer[stack.size()-1] = stack.pop();

            return answer;
        }
    }
}
