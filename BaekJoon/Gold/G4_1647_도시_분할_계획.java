package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1647_도시_분할_계획 {
    public static int N;
    public static int M;
    public static int cost;

    public static int[] parent;

    public static int[][] town;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = 0;
        parent = new int[N];
        town = new int[M][3];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<3; j++)
                town[i][j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(town, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        makeSet();
        Kruskal();

        System.out.println(cost);
    }

    public static void makeSet() {
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }
    }

    public static int findSet(int x) {
        if(parent[x] == x)
            return x;

        return findSet(parent[x]);
    }

    public static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if(x > y)
            parent[x] = y;
        else
            parent[y] = x;
    }

    public static void Kruskal() {
        int max = -1;

        for(int i=0; i<M; i++) {
            if(findSet(town[i][0] - 1) != findSet(town[i][1] - 1)) {
                union(town[i][0] - 1, town[i][1] - 1);
                cost += town[i][2];
                // 크루스칼 알고리즘을 통해, 최소 신장 트리를 얻었다. 이는 모든 집들이 연결되어 있다.
                // 이 중 간선 하나를 자르면, 그 집 하나 자체가 마을이 된다.
                // 따라서 크루스칼 알고리즘으로 가중치의 최소 합을 가진 상태에서
                // 가장 큰 가중치를 가진 간선 하나를 자르면 된다.
                max = Math.max(max, town[i][2]);
            }
        }

        cost -= max;
    }
}
