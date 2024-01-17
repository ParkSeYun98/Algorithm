package Programmers.JAVA.Lv_3;

import java.util.*;

class Lv_3_네트워크 {
    Queue<Integer> queue;
    boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        queue = new LinkedList<>();
        visited = new boolean[n];

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                BFS(i, computers);
            }
        }

        return answer;
    }

    void BFS(int start, int[][] computers) {
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=0; i<computers[now].length; i++) {
                if(computers[now][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
