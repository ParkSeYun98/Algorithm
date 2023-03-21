package Programmers.Lv_2;

import java.util.*;

class Lv_2_뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++) {
            if(stack.isEmpty() || numbers[i-1] > numbers[i])
                stack.push(i);

            else {
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
                    answer[stack.pop()] = numbers[i];

                stack.push(i);
            }
        }

        while(!stack.isEmpty())
            answer[stack.pop()] = -1;

        return answer;
    }
}