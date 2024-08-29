package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_압축 {

    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        char alpha = 'A';

        for(int i=1; i<=26; i++) {
            map.put(alpha + "", i);
            alpha += 1;
        }

        int idx = 0;

        while(idx < msg.length()) {
            String str = "";

            while(idx < msg.length()) {
                if(map.containsKey(str + msg.charAt(idx)))
                    str += msg.charAt(idx);
                else
                    break;

                idx++;
            }

            list.add(map.get(str));
            if(idx < msg.length())
                map.put(str + msg.charAt(idx), map.size()+1);
        }

        int[] result = new int[list.size()];

        for(int i=0; i<list.size(); i++)
            result[i] = list.get(i);

        return result;
    }
}
