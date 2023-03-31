package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_17471_게리맨더링 {
    private static int N;
    private static int min = Integer.MAX_VALUE;

    private static int[] population;
    private static boolean[] sel;

    private static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        population = new int[N];
        sel = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            population[i] = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int temp = Integer.parseInt(st.nextToken());

            adjList[i] = new ArrayList<>();

            for(int j=0; j<temp; j++)
                adjList[i].add(Integer.parseInt(st.nextToken()));
        }

        PowerSet(0, 0);

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    public static void PowerSet(int depth, int idx) {
        if(depth == N) {
            if(checkPossible()) {
                int diff = getDifference();
                min = Math.min(min, diff);
            }

            return;
        }

        for(int i=idx; i<N; i++) {
            sel[i] = false;
            PowerSet(depth+1, i+1);

            sel[i] = true;
            PowerSet(depth+1, i+1);
        }
    }

    public static boolean checkPossible() {
        List<Integer> redList = new ArrayList<>();
        List<Integer> blueList = new ArrayList<>();

        for(int i=0; i<sel.length; i++) {
            if(!sel[i])
                redList.add(i+1);
            else
                blueList.add(i+1);
        }

        if(redList.size() == 0 || blueList.size() == 0)
            return false;

        boolean[] redVisited = new boolean[N+1];
        boolean[] blueVisited = new boolean[N+1];

        BFS(redList, redVisited, redList.get(0));
        for(int i=0; i<redList.size(); i++) {
            if(!redVisited[redList.get(i)])
                return false;
        }

        BFS(blueList, blueVisited, blueList.get(0));
        for(int i=0; i<blueList.size(); i++) {
            if(!blueVisited[blueList.get(i)])
                return false;
        }

        return true;
    }

    public static void BFS(List<Integer> list, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i=0; i<list.size(); i++) {
                int next = list.get(i);

                if(visited[next])
                    continue;

                if(adjCheck(now, next)) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static boolean adjCheck(int s, int e) {
        for(int i=0; i<adjList[s].size(); i++) {
            if(adjList[s].get(i) == e)
                return true;
        }

        return false;
    }

    public static int getDifference() {
        int popRed = 0;
        int popBlue = 0;

        for(int i=0; i<sel.length; i++) {
            if(!sel[i])
                popRed += population[i];
            else
                popBlue += population[i];
        }

        return Math.abs(popRed - popBlue);
    }
}
