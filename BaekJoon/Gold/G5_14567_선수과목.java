package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_14567_선수과목 {
    private static int N;
    private static int M;

    private static int[] parentCnt;
    private static int[] result;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parentCnt = new int[N+1];
        result = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[A].add(B);
            parentCnt[B]++;
        }

        TopologicalSort();

        Print();
    }

    public static void TopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<parentCnt.length; i++) {
            if(parentCnt[i] == 0)
                queue.offer(i);
        }

        int semester = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while (size-- != 0) {
                int now = queue.poll();
                result[now] = semester;

                for (int child : graph[now]) {
                    if (--parentCnt[child] == 0)
                        queue.offer(child);
                }
            }

            semester++;
        }
    }

    public static void Print() {
        for(int i=1; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
