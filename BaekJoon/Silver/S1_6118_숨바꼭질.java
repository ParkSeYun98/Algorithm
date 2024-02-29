package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_6118_숨바꼭질 {

    static int N, M, maxNode, maxDist, maxCnt;

    static List<Integer>[] farm;

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxNode = 0;
        maxDist = 0;
        maxCnt = 0;
        farm = new ArrayList[N+1];

        for(int i=0; i<farm.length; i++)
            farm[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            farm[S].add(E);
            farm[E].add(S);
        }

        hideOnFarm();

        System.out.println(maxNode + " " + maxDist + " " + maxCnt);
    }

    static void hideOnFarm() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0));

        boolean[] visited = new boolean[N+1];
        visited[1] = true;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

        if(maxDist < now.dist) {
            maxDist = now.dist;
            maxNode = now.node;
            maxCnt = 1;
        }
        else if(maxDist == now.dist) {
            if(maxNode > now.node)
                maxNode = now.node;
            maxCnt++;
        }

            for (Integer next : farm[now.node]) {
                if(!visited[next]) {
                    queue.offer(new Node(next, now.dist+1));
                    visited[next] = true;
                }
            }
        }
    }
}
