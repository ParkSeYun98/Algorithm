package Programmers.JAVA.Lv_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lv_1_K번째_수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++) {
                List<Integer> list = new ArrayList<>();

                for(int j=commands[i][0]-1; j<=commands[i][1]-1; j++)
                    list.add(array[j]);

                Collections.sort(list);

                answer[i] = list.get(commands[i][2]-1);
            }

            return answer;
        }
    }
}
