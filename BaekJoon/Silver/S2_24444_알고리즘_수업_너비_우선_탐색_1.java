package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_24444_알고리즘_수업_너비_우선_탐색_1 {

    static int N, M, R, idx;

    static int[] order;

    static List<Integer> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        idx = 1;
        order = new int[N+1];
        list = new ArrayList[N+1];

        for(int i=0; i<list.length; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        BFS(R);

        for(int i=1; i<order.length; i++)
            System.out.println(order[i]);
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        order[start] = idx++;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            List<Integer> tempList = list[now];

            Collections.sort(tempList);

            for(int i=0; i<tempList.size(); i++) {
                int next = tempList.get(i);

                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    order[next] = idx++;
                }
            }
        }
    }
}
