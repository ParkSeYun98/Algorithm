/*
* Time : 408 ms
* Memory : 60932 KB
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G4_25195_Yes_or_yes {

    private static int N;
    private static int M;
    private static int S;
    private static String yesoryes = "Yes";

    private static int[] s;

    private static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=0; i<graph.length; i++)
            graph[i] = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
        }

        S = Integer.parseInt(br.readLine());

        s = new int[S];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<S; i++)
            s[i] = Integer.parseInt(st.nextToken());

        DFS(1);

        System.out.println(yesoryes);
    }

    public static void DFS(int start) {
        if(fanCheck(start))
            return;

        if(graph[start].isEmpty()) {
            yesoryes = "yes";
            return;
        }

        for(int i=0; i<graph[start].size(); i++)
            DFS(graph[start].get(i));
    }

    public static boolean fanCheck(int start) {
        boolean flag = false;

        for (int i : s) {
            if(i == start) {
                flag = true;
                break;
            }
        }

        return flag;
    }
}
