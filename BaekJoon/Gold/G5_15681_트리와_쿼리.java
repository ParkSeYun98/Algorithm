/*
* Memory : 93192 KB
* Time : 772 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_15681_트리와_쿼리 {

    private static int N;
    private static int R;
    private static int Q;

    private static int[] parent;
    private static int[] size;

    private static List<Integer>[] list;
    private static List<Integer>[] tree;

    private static Queue<Integer> queue = new LinkedList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        size = new int[N+1];
        list = new ArrayList[N+1];
        tree = new ArrayList[N+1];

        for(int i=0; i<list.length; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i<tree.length; i++)
            tree[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list[U].add(V);
            list[V].add(U);
        }

        makeSubTree(R,-1);
        count(R);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<Q; i++) {
            int temp = Integer.parseInt(br.readLine());
            sb.append(size[temp]).append("\n");
        }

        System.out.println(sb);
    }

    public static void makeSubTree(int now, int p) {
        for (Integer i : list[now]) {
            if(i != p) {
                tree[now].add(i);
                parent[i] = now;
                makeSubTree(i, now);
            }
        }
    }

    public static void count(int now) {
        size[now] = 1;

        for (Integer i : tree[now]) {
            count(i);
            size[now] += size[i];
        }
    }
}
