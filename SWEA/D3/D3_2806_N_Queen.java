package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_2806_N_Queen {
    private static int N;
    private static int result;

    private static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            // 열 배열
            line = new int[N];
            result = 0;

            DFS(0);

            System.out.println("#" + tc + " " + result);
        }
    }

    public static void DFS(int depth) {
        if(depth == N) {
            result++;
            return;
        }

        for(int i=0; i<N; i++) {
            // 한 열에는 하나만 배치될 수 있다.
            line[depth] = i;

            if(Check(depth))
                DFS(depth+1);
        }
    }

    public static boolean Check(int depth) {
        for(int i=0; i<depth; i++) {
            // 같은 행 체크
            if(line[depth] == line[i])
                return false;
            // 대각선 체크
            else if(Math.abs(depth - i) == Math.abs(line[depth] - line[i]))
                return false;
        }

        return true;
    }
}
