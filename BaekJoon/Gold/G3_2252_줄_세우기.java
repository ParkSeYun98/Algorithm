package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_2252_줄_세우기 {
    private static int N;
    private static int M;

    private static int[] degree;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            degree[B]++;
        }

        TopologicalSort();
    }

    public static void TopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<degree.length; i++) {
            if(degree[i] == 0)
                queue.offer(i);
        }

        int order = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- != 0) {
                int now = queue.poll();
                System.out.print(now + " ");

                for(int child : graph[now]) {
                    if(--degree[child] == 0)
                        queue.offer(child);
                }

                order++;
            }
        }
    }
}
