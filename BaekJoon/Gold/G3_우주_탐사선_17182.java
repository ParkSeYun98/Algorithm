package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_우주_탐사선_17182 {
    static int N;
    static int K;
    static int min = Integer.MAX_VALUE;

    static boolean[] visited;

    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        distance = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                distance[i][j] = Integer.parseInt(st.nextToken());
        }

        Floyd_Warshall();

        visited = new boolean[N];
        visited[K] = true;

        DFS(0, 0, K);

        System.out.println(min);
    }

    static void Floyd_Warshall() {
        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
    }

    static void DFS(int depth, int partSum, int before) {
        if(depth == N-1) {
            min = Math.min(min, partSum);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(depth+1, partSum + distance[before][i], i);
                visited[i] = false;
            }
        }
    }
}
