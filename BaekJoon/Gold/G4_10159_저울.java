package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_10159_저울 {
    private static int N;
    private static int M;

    private static int[][] arr1;
    private static int[][] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr1 = new int[N+1][N+1];
        arr2 = new int[N+1][N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr1[a][b] = 1;
            arr2[b][a] = 1;
        }

        for(int i=1; i<=N; i++) {
            arr1[i][i] = 1;
            arr2[i][i] = 1;
        }

        Floyd_Warshall();

        Check();
    }

    public static void Floyd_Warshall() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(arr1[i][k] == 1 && arr1[k][j] == 1)
                        arr1[i][j] = 1;

                    if(arr2[i][k] == 1 && arr2[k][j] == 1)
                        arr2[i][j] = 1;
                }
            }
        }
    }

    public static void Check() {
        int cnt = 0;

        for(int i=1; i<=N; i++) {
            cnt = 0;
            for(int j=1; j<=N; j++) {
                if(arr1[i][j] == 0 && arr2[i][j] == 0)
                    cnt++;
            }

            System.out.println(cnt);
        }
    }
}
