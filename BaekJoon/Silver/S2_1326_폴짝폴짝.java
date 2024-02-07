/*
* Memory : 13832 KB
* Time : 120 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2_1326_폴짝폴짝 {

    static int N;
    static int start;
    static int end;

    static int[] bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        bridge = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            bridge[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;

        BFS();
    }

    static void BFS() {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));

        boolean[] visited = new boolean[N];
        visited[start] = true;

        while(!queue.isEmpty()) {
            Pair now = queue.poll();

            if(now.node == end) {
                System.out.println(now.cnt);
                return;
            }

            int plusIdx = 1;

            while(true) {
                int next = now.node + bridge[now.node]*plusIdx;

                if(next >= N)
                    break;

                if(!visited[next]) {
                    queue.offer(new Pair(next, now.cnt+1));
                    visited[next] = true;
                }

                plusIdx++;
            }

            int minusIdx = 1;

            while(true) {
                int next = now.node - bridge[now.node]*minusIdx;

                if(next < 0)
                    break;

                if(!visited[next]) {
                    queue.offer(new Pair(next, now.cnt+1));
                    visited[next] = true;
                }

                minusIdx++;
            }
        }

        System.out.println(-1);
    }

    static class Pair {
        int node;
        int cnt;

        public Pair(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }
}
