package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_1707_이분_그래프 {

    static int V, E;

    static int[] check;

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());

        for(int tc=0; tc<K; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for(int i=0; i<graph.length; i++)
                graph[i] = new ArrayList<>();

            for(int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                graph[end].add(start);
            }

            check = new int[V+1];
            boolean flag = false;

            for(int i=1; i<=V; i++) {
                if(check[i] == 0)
                    flag = BFS(i);

                if(!flag)
                    break;
            }

            if(flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        check[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=0; i<graph[now].size(); i++) {
                int next = graph[now].get(i);

                if(check[now] == check[next])
                    return false;

                if(check[next] == 0) {
                    check[next] = check[now] * -1;
                    queue.offer(next);
                }
            }
        }

        return true;
    }
}
