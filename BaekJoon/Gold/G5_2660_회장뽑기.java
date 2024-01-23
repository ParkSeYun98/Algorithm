/*
* Memory : 11872 KB
* Time : 84 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_2660_회장뽑기 {

    static int N;

    static int[] scores;

    static List<Integer> graph[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        scores = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());

            if(p1 == -1 && p2 == -1)
                break;

            graph[p1].add(p2);
            graph[p2].add(p1);
        }

        int min = Integer.MAX_VALUE;

        for(int i=1; i<=N; i++) {
            scores[i] = BFS(i);
            min = Math.min(min, scores[i]);
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(scores[i] == min) {
                cnt++;
                list.add(i);
            }
        }

        System.out.println(min + " " + cnt);
        for (Integer i : list)
            System.out.print(i + " ");
    }

    static int BFS(int start) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.offer(new Node(start, 0));
        visited[start] = true;

        int max = -1;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            max = Math.max(max, now.depth);

            for (Integer next : graph[now.node]) {
                if(!visited[next]) {
                    queue.offer(new Node(next, now.depth+1));
                    visited[next] = true;
                }
            }
        }

        return max;
    }

    static class Node {
        int node;
        int depth;

        public Node(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
