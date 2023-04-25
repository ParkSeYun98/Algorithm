package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_21940_가운데에서_만나기 {
    static int N;
    static int M;
    static int K;

    static int[] city;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int INF = 1_000_000_000;

        distance = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            if(distance[A][B] > T)
                distance[A][B] = T;
        }

        K = Integer.parseInt(br.readLine());

        city = new int[K+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=K; i++)
            city[i] = Integer.parseInt(st.nextToken());

        Floyd_Warshall();

        int min = Integer.MAX_VALUE;
        int[] max = new int[N+1];

        for(int i=1; i<=N; i++) {
            for(int j=1; j<city.length; j++)
                max[i] = Math.max(max[i], distance[i][city[j]] + distance[city[j]][i]);

            min = Math.min(min, max[i]);
        }

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            if(min >= max[i])
                list.add(i);
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int city : list)
            sb.append(city).append(" ");

        System.out.println(sb);
    }

    static void Floyd_Warshall() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }
    }
}
