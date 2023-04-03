package SWEA.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D6_1267_작업순서 {
    private static int V;
    private static int E;

    private static int[] indegree;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc=1; tc<=10; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for(int i=0; i<graph.length; i++)
                graph[i] = new ArrayList<>();

            indegree = new int[V+1];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<E; i++) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                graph[s].add(e);
                indegree[e]++;
            }

            TopologicalSort(tc);
        }
    }

    public static void TopologicalSort(int tc) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<indegree.length; i++) {
            if(indegree[i] == 0)
                queue.offer(i);
        }

        System.out.print("#" + tc + " ");

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");

            for(int next : graph[now]) {
                if(--indegree[next] == 0)
                    queue.offer(next);
            }
        }

        System.out.println();
    }
}
