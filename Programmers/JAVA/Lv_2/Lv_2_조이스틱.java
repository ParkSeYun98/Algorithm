package Programmers.JAVA.Lv_2;

public class Lv_2_조이스틱 {
    class Solution {
        public int solution(String name) {

            int count = 0;
            int idx = -1;
            int minUpDown = 0;
            int minLeftRight = name.length() - 1;

            for(int i=0; i<name.length(); i++) {
                char now = name.charAt(i);

                minUpDown = Math.min(now - 'A', 'Z' - now + 1);
                count += minUpDown;
                minUpDown = 0;

                idx = i+1;

                while(idx < name.length() && name.charAt(idx) == 'A')
                    idx++;

                // 1. 정방향으로 쭉
                // 2. 정방향으로 가다가 연속되는 A를 만났을 때 역방향으로 바꾸기
                // 3. 역방향으로 가다가 연속되는 A를 만났을 때 정방향으로 바꾸기
                minLeftRight = Math.min(minLeftRight, Math.min((2 * i) + name.length() - idx, 2 * (name.length() - idx) + i));
            }

            count += minLeftRight;

            return count;
        }
    }
}
