package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_튜플 {

    public int[] solution(String s) {
        Map<Integer, Integer> map = new HashMap<>();

        String str = "";

        for(int i=1; i<s.length()-1; i++) {
            char now = s.charAt(i);

            if(now == '{' || now == '}' || now == ',') {
                if(str.equals(""))
                    continue;

                int num = Integer.parseInt(str);
                int cnt = 0;

                if(map.containsKey(num)) {
                    cnt = map.get(num);
                    map.put(num, cnt+1);
                }
                else
                    map.put(num, 1);

                str = "";
                continue;
            }
            else
                str += now;
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue()-o1.getValue());

        int[] result = new int[list.size()];

        for(int i=0; i<list.size(); i++)
            result[i] = list.get(i).getKey();

        return result;
    }
}
