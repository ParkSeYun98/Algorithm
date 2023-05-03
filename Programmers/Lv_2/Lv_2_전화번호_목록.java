package Programmers.Lv_2;

import java.util.*;

// map을 거꾸로 입력 받아서 (Integer, String) map.containsValue 메서드를 활용했을 때는 시간 초과가 났다.
// containsKey()는 O(1)의 시간복잡도, containsValue()는 O(N)의 시간복잡도이기 때문!
public class Lv_2_전화번호_목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<phone_book.length; i++)
                map.put(phone_book[i], i);

            for(int i=0; i<phone_book.length; i++) {
                for(int j=0; j<phone_book[i].length(); j++) {
                    if(map.containsKey(phone_book[i].substring(0, j))) {
                        answer = false;
                        return answer;
                    }
                }
            }

            return answer;
        }
    }
}
