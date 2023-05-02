package Programmers.Lv_1;

import java.util.*;

public class Lv_1_모의고사 {
    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};

            List<Integer> student1 = new ArrayList<>();
            List<Integer> student2 = new ArrayList<>();
            List<Integer> student3 = new ArrayList<>();

            int[] rule1 = {1, 2, 3, 4, 5};
            int[] rule2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] rule3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int idx = 0;
            boolean[] flag = new boolean[3];

            while(true) {
                if(flag[0] && flag[1] && flag[2])
                    break;

                for(int i=0; i<rule1.length; i++) {
                    if(student1.size() >= answers.length) {
                        flag[0] = true;
                        break;
                    }

                    student1.add(rule1[i]);
                }

                for(int i=0; i<rule2.length; i++) {
                    if(student2.size() >= answers.length) {
                        flag[1] = true;
                        break;
                    }

                    student2.add(rule2[i]);
                }

                for(int i=0; i<rule3.length; i++) {
                    if(student3.size() >= answers.length) {
                        flag[2] = true;
                        break;
                    }

                    student3.add(rule3[i]);
                }

                idx++;
            }

            int[] cnt = new int[4];

            for(int i=0; i<answers.length; i++) {
                if(answers[i] == student1.get(i))
                    cnt[1]++;

                if(answers[i] == student2.get(i))
                    cnt[2]++;

                if(answers[i] == student3.get(i))
                    cnt[3]++;
            }

            int max = Math.max(cnt[1], Math.max(cnt[2], cnt[3]));

            List<Integer> maxList = new ArrayList<>();

            for(int i=1; i<4; i++) {
                if(cnt[i] == max)
                    maxList.add(i);
            }

            answer = new int[maxList.size()];

            for(int i=0; i<maxList.size(); i++)
                answer[i] = maxList.get(i);

            return answer;
        }
    }
}
