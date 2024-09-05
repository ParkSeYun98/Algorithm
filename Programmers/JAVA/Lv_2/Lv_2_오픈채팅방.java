package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_오픈채팅방 {

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int changeCnt = 0;

        for(int i=0; i<record.length; i++) {
            String str = record[i];
            String[] strArr = str.split(" ");

            if(strArr[0].equals("Enter"))
                map.put(strArr[1], strArr[2]);
            else if(strArr[0].equals("Change") && map.containsKey(strArr[1])) {
                map.put(strArr[1], strArr[2]);
                changeCnt++;
            }
        }

        String[] result = new String[record.length-changeCnt];

        int idx = 0;

        for(int i=0; i<record.length; i++) {
            String str = record[i];
            String[] strArr = str.split(" ");

            if(strArr[0].equals("Change"))
                continue;
            else {
                result[idx] = map.get(strArr[1]) + "님이 ";

                if(strArr[0].equals("Enter"))
                    result[idx] += "들어왔습니다.";
                else if(strArr[0].equals("Leave"))
                    result[idx] += "나갔습니다.";
            }

            idx++;
        }

        return result;
    }
}
