package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_이진_변환_반복하기 {

    public int[] solution(String s) {
        int[] answer = new int[2];

        int zeroCnt = 0;
        int changeCnt = 0;

        while(true) {
            if(s.equals("1"))
                break;

            String noZero = "";

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '1')
                    noZero += "1";
                else
                    zeroCnt++;
            }

            int len = noZero.length();
            StringBuilder sb = new StringBuilder();

            while(true) {
                if(len == 0)
                    break;

                if(len%2 == 0)
                    sb.append("0");
                else
                    sb.append("1");

                len /= 2 ;
            }

            s = sb.reverse().toString();
            changeCnt++;
        }

        answer[0] = changeCnt;
        answer[1] = zeroCnt;

        return answer;
    }
}
