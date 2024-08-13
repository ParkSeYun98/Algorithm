package Programmers.JAVA.Lv_2;

public class Lv_2_최댓값과_최솟값 {

    public String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<strArr.length; i++) {
            int now = Integer.parseInt(strArr[i]);

            max = Math.max(max, now);
            min = Math.min(min, now);
        }

        answer += min;
        answer += " ";
        answer += max;

        return answer;
    }
}
