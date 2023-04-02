package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_21276_계보_복원가_호석 {
    private static int N;
    private static int M;

    private static String[] family;
    private static int[] degree;

    private static HashMap<String, Integer> familyMap;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        family = new String[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            family[i] = st.nextToken();

        Arrays.sort(family);

        familyMap = new HashMap<>();
        for(int i=0; i<family.length; i++)
            familyMap.put(family[i], i);

        degree= new int[N];
        graph = new ArrayList[N];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String child = st.nextToken();
            String parent = st.nextToken();

            int childNo = familyMap.get(child);
            int parentNo = familyMap.get(parent);

            graph[parentNo].add(childNo);
            degree[childNo]++;
        }

        TopologicalSort();
    }

    public static void TopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> oldest = new ArrayList<>();
        List<Integer> baby[] = new ArrayList[N];
        for(int i=0; i<baby.length; i++)
            baby[i] = new ArrayList<>();

        for(int i=0; i<degree.length; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
                oldest.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : graph[now]) {
                if(--degree[next] == 0) {
                    queue.offer(next);
                    baby[now].add(next);
                }
            }
        }

        System.out.println(oldest.size());

        for(int i=0; i<oldest.size(); i++)
            System.out.print(family[oldest.get(i)] + " ");

        System.out.println();

        for(int i=0; i<baby.length; i++) {
            System.out.print(family[i] + " " + baby[i].size() + " ");

            Collections.sort(baby[i]);

            for(int j=0; j<baby[i].size(); j++)
                System.out.print(family[baby[i].get(j)] + " ");

            System.out.println();
        }
    }
}
