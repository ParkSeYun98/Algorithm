package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class S2_1058_친구 {

    static int N, max;

    static char[][] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        friend = new char[N][N];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                friend[i][j] = input.charAt(j);
        }

        max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++)
            getFriend(i);

        System.out.println(max);
    }

    static void getFriend(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        boolean[] visited = new boolean[N];
        visited[start] = true;

        int cnt = 0;
        int depth = 0;

        while(depth < 2) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int now = queue.poll();

                for(int j=0; j<N; j++) {
                    if(visited[j])
                        continue;

                    if(friend[now][j] == 'N')
                        continue;

                    queue.offer(j);
                    cnt++;
                    visited[j] = true;
                }
            }

            depth++;
        }

        max = Math.max(max, cnt);
    }
}
