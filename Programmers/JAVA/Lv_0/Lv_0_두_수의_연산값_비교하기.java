package Programmers.JAVA.Lv_0;

public class Lv_0_두_수의_연산값_비교하기 {
    class Solution {
        public int solution(int a, int b) {
            int answer = 0;

            String str = "";

            str += String.valueOf(a);
            str += String.valueOf(b);

            answer = Math.max(Integer.parseInt(str), 2*a*b);

            return answer;
        }
    }
}
