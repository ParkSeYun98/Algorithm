package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_3980_선발명단 {

    static int maxSum;

    static int[] bestPosition;

    static int[][] player;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        for(int tc=0; tc<C; tc++) {
            maxSum = Integer.MIN_VALUE;
            visited = new boolean[11];
            bestPosition = new int[11];
            player = new int[11][11];

            for(int i=0; i<11; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<11; j++)
                    player[i][j] = Integer.parseInt(st.nextToken());
            }

            findBestPosition(0);

            System.out.println(maxSum);
        }
    }

    static void findBestPosition(int depth) {
        if(depth == 11) {
            int sum = 0;

            for(int i=0; i<bestPosition.length; i++)
                sum += bestPosition[i];

            maxSum = Math.max(maxSum, sum);

            return;
        }

        for(int i=0; i<11; i++) {
            if(!visited[i] && player[depth][i] != 0) {
                visited[i] = true;
                bestPosition[i] = player[depth][i];
                findBestPosition(depth+1);
                visited[i] = false;
            }
        }
    }
}
