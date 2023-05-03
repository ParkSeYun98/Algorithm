package Programmers.Lv_2;

import java.util.*;

public class Lv_2_의상 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;

            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<clothes.length; i++)
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);

            Iterator<Integer> iter = map.values().iterator();
            answer = 1;

            while(iter.hasNext())
                answer *= iter.next() + 1;

            answer--;

            return answer;
        }
    }
}
