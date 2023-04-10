package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_11048_이동하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                maze[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(i==0 && j==0)
                    continue;
                else if(i==0)
                    maze[i][j] += maze[i][j-1];
                else if(j==0)
                    maze[i][j] += maze[i-1][j];
                else
                    maze[i][j] += Math.max(maze[i - 1][j - 1], Math.max(maze[i - 1][j], maze[i][j - 1]));
            }
        }

        System.out.println(maze[N-1][M-1]);
    }
}
