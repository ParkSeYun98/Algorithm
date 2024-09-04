package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_택배상자 {

    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        int cnt = 0;

        for(int i=1; i<=order.length; i++) {
            if(!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                idx++;
                cnt++;
            }

            if(i==order[idx]) {
                idx++;
                cnt++;
            }
            else {
                stack.push(i);
            }
        }

        while(!stack.isEmpty()) {
            int now = stack.pop();

            if(order[idx] == now) {
                idx++;
                cnt++;
            }
            else
                break;
        }

        return cnt;
    }
}
