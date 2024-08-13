package Programmers.JAVA.Lv_2;

public class Lv_2_JadenCase_문자열_만들기 {

    public String solution(String s) {
        String answer = "";

        String[] strArr = s.split(" ");

        for(int i=0; i<strArr.length; i++) {
            String now = strArr[i];

            if(strArr[i].length() == 0)
                answer += " ";
            else {
                answer += now.substring(0, 1).toUpperCase();
                answer += now.substring(1, now.length()).toLowerCase();

                answer += " ";
            }
        }

        if(s.charAt(s.length()-1) != ' ')
            return answer.substring(0, answer.length()-1);
        else
            return answer;
    }
}
