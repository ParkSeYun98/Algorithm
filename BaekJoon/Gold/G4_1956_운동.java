/*
* Memory : 65208 KB
* Time : 656 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1956_운동 {

    static final int INF = 987_654_321;

    static int V, E;

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V+1][V+1];

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[0].length; j++)
                graph[i][j] = INF;
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        floydWarshall();
        getCycle();
    }

    static void floydWarshall() {
        for(int k=1; k<=V; k++) {
            for(int i=1; i<=V; i++) {
                for(int j=1; j<=V; j++) {
                    if(i == j)
                        continue;

                    if(graph[i][j] > graph[i][k] + graph[k][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }

    static void getCycle() {
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                if(i == j)
                    continue;

                if(graph[i][j] != INF && graph[j][i] != INF)
                    min = Math.min(min, graph[i][j] + graph[j][i]);
            }
        }

        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
