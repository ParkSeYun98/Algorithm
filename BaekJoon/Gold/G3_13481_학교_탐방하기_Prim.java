/*
* Memory : 234816 KB
* Time : 1256 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class G3_13481_학교_탐방하기_Prim {

    private static int N;
    private static int M;
    private static int minFatigue = 0;
    private static int maxFatigue = 0;

    private static List<ascNode>[] ascRoad;
    private static List<descNode>[] descRoad;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken()) + 1;
        M = Integer.parseInt(st.nextToken()) + 1;

        ascRoad = new ArrayList[N];
        descRoad = new ArrayList[N];

        for(int i=0; i<ascRoad.length; i++)
            ascRoad[i] = new ArrayList<>();

        for(int i=0; i<descRoad.length; i++)
            descRoad[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(C == 1)
                C = 0;
            else if(C == 0)
                C = 1;

            ascRoad[A].add(new ascNode(B, C));
            ascRoad[B].add(new ascNode(A, C));
            descRoad[A].add(new descNode(B, C));
            descRoad[B].add(new descNode(A, C));

        }

        ascPrim();
        descPrim();

        System.out.println(maxFatigue - minFatigue);
    }

    public static void ascPrim() {
        PriorityQueue<ascNode> pq = new PriorityQueue<>();
        pq.offer(new ascNode(0, 0));

        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()) {
            ascNode now = pq.poll();

            if(visited[now.node])
                continue;
            
            visited[now.node] = true;
            minFatigue += now.weight;

            for (ascNode next : ascRoad[now.node]) {
                if(!visited[next.node])
                    pq.offer(next);
            }
        }

        minFatigue *= minFatigue;
    }

    public static void descPrim() {
        PriorityQueue<descNode> pq = new PriorityQueue<>();
        pq.offer(new descNode(0, 0));

        boolean[] visited = new boolean[N+1];

        while(!pq.isEmpty()) {
            descNode now = pq.poll();

            if(visited[now.node])
                continue;

            visited[now.node] = true;
            maxFatigue += now.weight;

            for (descNode next : descRoad[now.node]) {
                if(!visited[next.node])
                    pq.offer(next);
            }
        }

        maxFatigue *= maxFatigue;
    }

    public static class ascNode implements Comparable<ascNode> {
        int node;
        int weight;

        public ascNode(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(ascNode o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static class descNode implements Comparable<descNode> {
        int node;
        int weight;

        public descNode(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(descNode o) {
            return Integer.compare(o.weight, this.weight);
        }
    }
}
