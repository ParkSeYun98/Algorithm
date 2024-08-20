package Programmers.JAVA.Lv_2;

import java.util.HashSet;

public class Lv_2_영어_끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();

        int turn = 0;
        int cnt = 1;
        boolean flag = false;

        for(int i=0; i<words.length; i++) {
            String now = words[i];

            if(++turn > n) {
                turn = 1;
                cnt++;
            }

            answer[0] = turn;
            answer[1] = cnt;

            if(!set.contains(now))
                set.add(now);
            else
                break;

            if(i!=0 && now.charAt(0) != words[i-1].charAt(words[i-1].length()-1))
                break;

            if(i == words.length-1)
                flag = true;
        }

        if(flag) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }
}
