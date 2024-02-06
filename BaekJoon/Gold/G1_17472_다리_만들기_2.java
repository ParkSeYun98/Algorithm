package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1_17472_다리_만들기_2 {

    static int N;
    static int M;
    static int islandCount;

    static int[] parent;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] nation;
    static boolean[][] visited;

    static PriorityQueue<Node> pq;

    static List<Point>[] islandList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nation = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                nation[i][j] = Integer.parseInt(st.nextToken());
        }

        /*
        * 1. 각 섬 구분하기 : BFS
        * */

        int idx = 1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!visited[i][j] && nation[i][j] == 1)
                    BFS(new Point(i, j), idx++);
            }
        }

        /*
        * 2. 구분한 섬을 배열 리스트에 담기 (이후 시간 효율과 편의성을 위한 것)
        * */

        islandList = new ArrayList[7];
        for(int i=0; i<islandList.length; i++)
            islandList[i] = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(nation[i][j] != 0)
                    islandList[nation[i][j]].add(new Point(i, j));
            }
        }

        islandCount = 0;

        for (List<Point> pointList : islandList) {
            if(!pointList.isEmpty())
                islandCount++;
        }

        /*
        * 3. 연결 가능한 모든 방법을 찾는다. : DFS
        * */

        pq = new PriorityQueue<>();

        for(int i=1; i<=islandCount; i++) {
            for(int j=0; j<islandList[i].size(); j++) {
                for(int d=0; d<4; d++)
                    DFS(islandList[i].get(j), i, d, -1);
            }
        }

        /*
        * 4. 최소 간선 구하기 : MST
        * */
        parent = new int[islandCount+1];

        Kruskal();
    }

    static void BFS(Point start, int idx) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        visited[start.r][start.c] = true;

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            nation[now.r][now.c] = idx;

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(!islandCheck(nextR, nextC, 1))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                queue.offer(new Point(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    static void DFS(Point now, int islandIdx, int direction, int length) {
        if(nation[now.r][now.c] != 0 && nation[now.r][now.c] != islandIdx) {
            if(length >= 2)
                pq.offer(new Node(islandIdx, nation[now.r][now.c], length));

            return;
        }

        int nextR = now.r + dr[direction];
        int nextC = now.c + dc[direction];

        if(outOfMapCheck(nextR, nextC))
            return;

        if(islandCheck(nextR, nextC, islandIdx))
            return;

        DFS(new Point(nextR, nextC), islandIdx, direction, length+1);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=N || c>=M;
    }

    static boolean islandCheck(int r, int c, int islandIdx) {
        return nation[r][c] == islandIdx;
    }

    static void makeSet() {
        for(int i=1; i<=islandCount; i++)
            parent[i] = i;
    }

    static int findSet(int x) {
        if(parent[x] == x)
            return x;

        return parent[x] = findSet(parent[x]);
    }

    static void union(int a, int b) {
        a = findSet(a);
        b = findSet(b);

        if(a > b)
            parent[a] = b;
        else
            parent[b] = a;
    }

    static void Kruskal() {
        makeSet();

        int bridgeCnt = 0;
        int minBridgeLength = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            int islandA = findSet(now.islandA);
            int islandB = findSet(now.islandB);

            if(islandA != islandB) {
                union(islandA, islandB);

                minBridgeLength += now.length;
                bridgeCnt++;
            }
        }

        if(minBridgeLength == 0 || bridgeCnt != islandCount - 1) {
            System.out.println(-1);

            return;
        }

        System.out.println(minBridgeLength);
    }

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Node implements Comparable<Node>{
        int islandA;
        int islandB;
        int length;

        public Node(int islandA, int islandB, int length) {
            this.islandA = islandA;
            this.islandB = islandB;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}
