package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_1325_효율적인_해킹 {

    static int N, M, max;

    static int[] cntArr;

    static List<Integer> maxIdxList;

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=0; i<list.length; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
        }

        max = Integer.MIN_VALUE;
        cntArr = new int[N+1];
        maxIdxList = new ArrayList<>();

        for(int i=1; i<=N; i++)
            BFS(i);

        for(int i=1; i<=N; i++) {
            if(max < cntArr[i])
                max = cntArr[i];
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++) {
            if (max == cntArr[i])
                sb.append(i).append(' ');
        }

        System.out.println(sb);
    }

    static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for (Integer next : list[now]) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    cntArr[next]++;
                }
            }
        }
    }
}
