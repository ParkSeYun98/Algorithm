package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_피로도 {
    class Solution {
        int max = Integer.MIN_VALUE;

        boolean[] visited;

        List<Integer> list;

        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];

            list = new ArrayList<>();

            DFS(k, dungeons);

            return max;
        }

        void DFS(int k, int[][] dungeons) {
            System.out.println(list.size());
            max = Math.max(max, list.size());

            for(int i=0; i<dungeons.length; i++) {
                if(!visited[i] && k >= dungeons[i][0]) {
                    visited[i] = true;
                    list.add(i);
                    k -= dungeons[i][1];
                    DFS(k, dungeons);
                    k += dungeons[i][1];
                    list.remove(list.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}
