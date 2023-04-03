package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G2_1766_문제집 {
    private static int N;
    private static int M;

    private static int[] indegree;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N+1];

        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            indegree[B]++;
        }

        TopologicalSort();
    }

    public static void TopologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<indegree.length; i++) {
            if(indegree[i] == 0)
                pq.offer(i);
        }

        while(!pq.isEmpty()) {
            int now = pq.poll();
            System.out.print(now + " ");

            for(int next : graph[now]) {
                if(--indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
    }
}
