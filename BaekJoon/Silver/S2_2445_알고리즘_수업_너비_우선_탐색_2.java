package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_2445_알고리즘_수업_너비_우선_탐색_2 {

    static int N, M, R;

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        BFS();
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(R);

        boolean[] visited = new boolean[N+1];
        visited[R] = true;

        int[] ans = new int[N+1];
        int idx = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            ans[now] = idx++;

            int[] arr = new int[graph[now].size()];

            for(int d=0; d<graph[now].size(); d++)
                arr[d] = graph[now].get(d);

            Arrays.sort(arr);

            for(int i=arr.length-1; i>=0; i--) {
                if(!visited[arr[i]]) {
                    queue.offer(arr[i]);
                    visited[arr[i]] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<ans.length; i++)
            sb.append(ans[i]).append('\n');

        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
    }
}
