package Programmers.JAVA.Lv_1;

import java.util.*;

class Lv_1_개인정보_수집_유효기간 {

    private Map<String, Integer> map = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        int todayDate = changeToDate(today);

        for(int i=0; i<terms.length; i++) {
            String term[] = terms[i].split(" ");
            map.put(term[0], Integer.parseInt(term[1]));
        }

        for(int i=0; i<privacies.length; i++) {
            String privacy[] = privacies[i].split(" ");

            if (changeToDate(privacy[0]) + (map.get(privacy[1])*28) <= todayDate)
                list.add(i+1);
        }

        answer = new int[list.size()];

        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

    public int changeToDate(String day) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int year = -1;
        int month = -1;
        int date = -1;

        for(int i=0; i<day.length(); i++) {
            char now = day.charAt(i);

            if(now != '.')
                sb.append(now);
            else {
                if(cnt == 0)
                    year = Integer.parseInt(sb.toString());
                else if(cnt == 1)
                    month = Integer.parseInt(sb.toString());

                sb = new StringBuilder();
                cnt++;
            }
        }

        if(cnt == 2)
            date = Integer.parseInt(sb.toString());

        return (year*12*28) + (month*28) + date;
    }
}