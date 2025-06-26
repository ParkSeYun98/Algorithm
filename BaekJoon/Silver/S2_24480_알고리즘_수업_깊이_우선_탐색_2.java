package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S2_24480_알고리즘_수업_깊이_우선_탐색_2 {

    static int N, M, R, idx;

    static int[] order;
    static boolean[] visited;

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
        visited = new boolean[N+1];
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

        visited[R] = true;
        order[R] = 1;
        DFS(R);

        for(int i=1; i<order.length; i++)
            System.out.println(order[i]);
    }

    static void DFS(int start) {
        visited[start] = true;
        order[start] = idx++;

        List<Integer> temp = list[start];

        temp.sort(Collections.reverseOrder());

        for(int i=0; i<temp.size(); i++) {
            int next = temp.get(i);

            if(!visited[next]) {
                DFS(next);
            }
        }
    }
}
