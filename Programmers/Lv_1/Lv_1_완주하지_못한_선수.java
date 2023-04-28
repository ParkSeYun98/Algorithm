package Programmers.Lv_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Lv_1_완주하지_못한_선수 {
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map<String, Integer> map = new HashMap<>();

            for(String runner : participant)
                map.put(runner, map.getOrDefault(runner, 0) + 1);

            for(String runner : completion)
                map.put(runner, map.get(runner) - 1);


            Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

            while(iter.hasNext()) {
                Map.Entry<String, Integer> entry = iter.next();

                if(entry.getValue() != 0) {
                    answer = entry.getKey();
                    break;
                }
            }

            return answer;
        }
    }
}
