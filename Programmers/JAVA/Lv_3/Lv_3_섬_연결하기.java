package Programmers.JAVA.Lv_3;

import java.util.*;

public class Lv_3_섬_연결하기 {
    class Solution {
        class Edge implements Comparable<Edge> {
            int target;
            int cost;

            public Edge(int target, int cost) {
                this.target = target;
                this.cost = cost;
            }

            @Override
            public int compareTo(Edge e) {
                return this.cost - e.cost;
            }
        }

        List<Edge> graph[];

        public int solution(int n, int[][] costs) {

            graph = new ArrayList[n+1];

            for(int i=0; i<graph.length; i++)
                graph[i] = new ArrayList<>();

            for(int i=0; i<costs.length; i++) {
                int start = costs[i][0];
                int end = costs[i][1];
                int cost = costs[i][2];

                graph[start].add(new Edge(end, cost));
                graph[end].add(new Edge(start, cost));
            }

            return Prim(n);
        }

        public int Prim(int n) {
            int min = 0;

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            boolean[] visited = new boolean[n+1];

            pq.offer(new Edge(0, 0));

            while(!pq.isEmpty()) {
                Edge now = pq.poll();

                if(visited[now.target])
                    continue;

                visited[now.target] = true;
                min += now.cost;

                for(Edge edge : graph[now.target]) {
                    if(!visited[edge.target])
                        pq.offer(edge);
                }
            }

            return min;
        }
    }
}
