package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_n진수_게임 {

    public String solution(int n, int t, int m, int p) {
        List<Character> list = new ArrayList<>();

        for(int i=0; i<t*m; i++) {
            String now = Integer.toString(i, n);

            for(int j=0; j<now.length(); j++)
                list.add(now.charAt(j));
        }

        String myNum = "";
        int order = 1;

        for(int i=0; i<list.size(); i++) {
            char now = list.get(i);

            if(now >= 97 && now <= 122)
                now -= 32;

            if(order > m)
                order = 1;

            if(order == p)
                myNum += String.valueOf(now);

            order++;

            if(myNum.length() == t)
                break;
        }

        return myNum;
    }
}
