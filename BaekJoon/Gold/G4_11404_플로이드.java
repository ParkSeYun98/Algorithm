package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_11404_플로이드 {
    static final int INF = 999_999_999;

    static int n;
    static int m;

    static int[][] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        info = new int[n+1][n+1];

        for(int i=1; i<info.length; i++) {
            for(int j=1; j<info[i].length; j++) {
                info[i][j] = INF;

                if(i == j)
                    info[i][j] = 0;
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info[a][b] = Math.min(info[a][b], c);
        }

        Floyd_Warshall();

        Print();
    }

    static void Floyd_Warshall() {
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++)
                    info[i][j] = Math.min(info[i][j], info[i][k] + info[k][j]);
            }
        }
    }

    static void Print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 갈 수 없는 곳은 0으로 초기화
                if (info[i][j] == INF) {
                    info[i][j] = 0;
                }

                sb.append(info[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
