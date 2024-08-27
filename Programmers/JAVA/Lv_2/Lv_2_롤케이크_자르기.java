package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_롤케이크_자르기 {

    public int solution(int[] topping) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        int cnt = 0;

        for(int t : topping)
            right.put(t, right.getOrDefault(t, 0)+1);

        for(int t : topping) {
            left.put(t, left.getOrDefault(t, 0)+1);

            if(right.get(t) == 1)
                right.remove(t);
            else
                right.put(t, right.get(t)-1);

            if(left.size() == right.size())
                cnt++;
        }

        return cnt;
    }
}
