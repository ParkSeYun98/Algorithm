package Programmers.JAVA.Lv_3;

import java.util.*;

class Lv_3_가장_먼_노드 {

    List<Node>[] graph;

    class Node {
        int node;
        int cnt;

        public Node(int node, int cnt) {
            this.node = node;
            this.cnt = cnt;
        }
    }

    public int solution(int n, int[][] edge) {
        init(n, edge);

        return BFS(n);
    }

    void init(int n, int[][] edge) {
        graph = new ArrayList[n+1];

        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];

            graph[start].add(new Node(end, 0));
            graph[end].add(new Node(start, 0));
        }
    }

    int BFS(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));

        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        int maxDist = 0;
        int maxDistCnt = 0;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(now.cnt == maxDist)
                maxDistCnt++;
            else if(now.cnt > maxDist) {
                maxDist = now.cnt;
                maxDistCnt = 1;
            }

            for(Node next : graph[now.node]) {
                if(visited[next.node])
                    continue;

                queue.offer(new Node(next.node, now.cnt+1));
                visited[next.node] = true;
            }
        }

        return maxDistCnt;
    }
}