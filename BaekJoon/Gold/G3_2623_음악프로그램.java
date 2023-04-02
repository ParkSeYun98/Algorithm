package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_2623_음악프로그램 {
    private static int N;
    private static int M;

    private static int[] degree;

    private static List<Integer> result;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            List<Integer> inputList = new ArrayList<>();

            int num = Integer.parseInt(st.nextToken());

            for(int j=0; j<num; j++)
                inputList.add(Integer.parseInt(st.nextToken()));

            for(int j=0; j<inputList.size()-1; j++) {
                graph[inputList.get(j)].add(inputList.get(j + 1));
                degree[inputList.get(j + 1)]++;
            }
        }

        result = new ArrayList<>();

        TopologicalSort();

        Print();
    }

    public static void TopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<degree.length; i++) {
            if(degree[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-- != 0) {
                int now = queue.poll();
                result.add(now);

                for(int next : graph[now]) {
                    if(--degree[next] == 0)
                        queue.offer(next);
                }
            }
        }
    }

    public static void Print() {
        if(result.size() != N)
            System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<result.size(); i++)
                sb.append(result.get(i)).append("\n");

            System.out.println(sb);
        }
    }
}
