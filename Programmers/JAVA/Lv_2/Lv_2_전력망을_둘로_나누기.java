package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_전력망을_둘로_나누기 {
    class Solution {
        int min = Integer.MAX_VALUE;

        int[][] arr;

        public int solution(int n, int[][] wires) {
            arr = new int[n+1][n+1];

            for(int i=0; i<wires.length; i++) {
                int a = wires[i][0];
                int b = wires[i][1];

                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            for(int i=0; i<wires.length; i++) {
                int a = wires[i][0];
                int b = wires[i][1];

                arr[a][b] = 0;
                arr[b][a] = 0;

                BFS(n, a);

                arr[a][b] = 1;
                arr[b][a] = 1;
            }

            return min;
        }

        void BFS(int n, int a) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(a);

            boolean[] visited = new boolean[n+1];
            visited[a] = true;

            int cnt = 0;

            while(!queue.isEmpty()) {
                int now = queue.poll();
                cnt++;

                for(int i=1; i<=n; i++) {
                    if(visited[i])
                        continue;

                    if(arr[now][i] == 1 && arr[i][now] == 1) {
                        visited[i] = true;
                        queue.offer(i);
                    }
                }
            }

            min = Math.min(min, Math.abs(cnt - (n - cnt)));
        }
    }
}
