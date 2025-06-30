package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_30702_국기_색칠하기 {

    static String[][] A, B;
    static int N, M;
    static boolean[][] visited;

    static int[][] dir = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new String[N][M];
        B = new String[N][M];
        visited = new boolean[N][M];

        for (int i=0; i < N; i++) {
            String[] str = br.readLine().split("");

            for (int j=0; j < M; j++)
                A[i][j] = str[j];
        }

        for (int i=0; i<N; i++) {
            String[] str = br.readLine().split("");

            for (int j=0; j < M; j++)
                B[i][j] = str[j];
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (!visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    dfs(i, j, A[i][j], queue);

                    if (!check(queue)) {
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }

        System.out.println("YES");
    }

    public static void dfs(int x, int y, String target, Queue<int[]> queue) {
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        for (int i=0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];

            if (x1>=0 && y1 >=0 && x1 < N && y1 < M && !visited[x1][y1] && target.equals(A[x1][y1]))
                dfs(x1, y1, target, queue);

        }
    }

    public static boolean check(Queue<int[]> queue) {
        int[] num = queue.poll();
        int x = num[0];
        int y = num[1];

        String target = B[x][y];

        while (!queue.isEmpty()) {
            num = queue.poll();
            x = num[0];
            y = num[1];

            String s = B[x][y];

            if (!target.equals(s))
                return false;
        }

        return true;
    }
}