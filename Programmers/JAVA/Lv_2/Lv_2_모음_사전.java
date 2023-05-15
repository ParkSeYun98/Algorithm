package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_모음_사전 {
    class Solution {
        String[] rule = {"A", "E", "I", "O", "U"};

        List<String> dictionary = new ArrayList<>();

        public int solution(String word) {
            int answer = 0;

            StringBuilder sb = new StringBuilder();

            DFS(0, sb);

            for(int i=0; i<dictionary.size(); i++) {
                if(word.equals(dictionary.get(i)))
                    answer = i;
            }

            return answer;
        }

        void DFS(int depth, StringBuilder sb) {
            if(depth == rule.length+1)
                return;

            dictionary.add(sb.toString());

            for(int i=0; i<rule.length; i++) {
                sb.append(rule[i]);
                DFS(depth+1, sb);
                sb.setLength(sb.length()-1);
            }
        }
    }
}
