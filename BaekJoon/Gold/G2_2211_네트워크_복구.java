/*
* Memory : 92064 KB
* Time : 628 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_2211_네트워크_복구 {

    static final int INF = Integer.MAX_VALUE;

    static int N, M;

    static int[] distance, route;

    static List<Node>[] network;

    static class Node implements Comparable<Node> {
        int node;
        int time;

        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        network = new ArrayList[N+1];

        for(int i=0; i<network.length; i++)
            network[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            network[A].add(new Node(B, C));
            network[B].add(new Node(A, C));
        }

        route = new int[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, INF);

        Djikstra();
        findRoute();
    }

    static void Djikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        distance[1] = 0;

        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;

            for (Node next : network[now.node]) {
                if(distance[next.node] > distance[now.node] + next.time) {
                    distance[next.node] = distance[now.node] + next.time;
                    pq.offer(new Node(next.node, distance[next.node]));
                    route[next.node] = now.node;
                }
            }
        }
    }

    static void findRoute() {
        List<String> routeList = new ArrayList<>();

        for(int i=2; i<N+1; i++) {
            int next = i;

            while(true) {
                if(route[next] == 0)
                    break;

                StringBuilder sb = new StringBuilder();
                sb.append(next).append(" ").append(route[next]);
                String tempRoute = sb.toString();

                if(!routeList.contains(tempRoute))
                    routeList.add(tempRoute);

                next = route[next];
            }
        }

        System.out.println(routeList.size());

        for (String partRoute : routeList)
            System.out.println(partRoute);
    }
}
