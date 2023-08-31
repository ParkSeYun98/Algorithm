package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class G5_15591_MooTube {

    private static int N;
    private static int Q;

    private static List<Node>[] usado;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        usado = new ArrayList[N+1];

        for(int i=0; i<=N; i++)
            usado[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            usado[start].add(new Node(end, value));
            usado[end].add(new Node(start, value));
        }

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            BFS(k, v);
        }
    }

    public static void BFS(int k, int v) {
        int cnt = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        boolean[] visited = new boolean[N+1];
        visited[v] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            List<Node> list = usado[now];

            for (Node one : list) {
                if(visited[one.node])
                    continue;

                if(one.cost < k)
                    continue;

                queue.offer(one.node);
                visited[one.node] = true;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static class Node {
        int node;

        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
