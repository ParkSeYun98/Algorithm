package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S2_24479_알고리즘_수업_깊이_우선_탐색_1 {

    static int N, M, R, order;

    static int[] visited;

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        order = 1;
        visited = new int[N+1];
        visited[R] = order++;

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

        for(int i=0; i<graph.length; i++)
            Collections.sort(graph[i]);

        DFS(R);

        for(int i=1; i<visited.length; i++)
            System.out.println(visited[i]);
    }

    static void DFS(int start) {
        for(int i=0; i<graph[start].size(); i++) {
            if(visited[graph[start].get(i)] == 0) {
                visited[graph[start].get(i)] = order++;
                DFS(graph[start].get(i));
            }
        }
    }
}
