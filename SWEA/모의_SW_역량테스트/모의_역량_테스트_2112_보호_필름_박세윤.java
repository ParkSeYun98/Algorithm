package SWEA.모의_SW_역량테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 모의_역량_테스트_2112_보호_필름_박세윤 {
    private static int D;
    private static int W;
    private static int K;
    private static int min;

    private static int[][] film;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];

            for(int i=0; i<D; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<W; j++)
                    film[i][j] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;

            DFS(0, 0);
            System.out.println("#" + tc + " " + min);
        }
    }

    public static boolean check() {
        boolean[] flag = new boolean[W];

        for(int j=0; j<W; j++) {
            int checkA = 0;
            int checkB = 0;

            for(int i=0; i<D; i++) {
                if(film[i][j] == 0) {
                    checkA++;
                    checkB = 0;
                }
                else {
                    checkA = 0;
                    checkB++;
                }

                if(checkA == K || checkB == K) {
                    flag[j] = true;
                    break;
                }
            }
            if(!flag[j])
                return false;
        }

        return true;
    }

    public static void DFS(int depth, int idx) {
        if(min < depth)
            return;
        if(depth > K)
            return;

        if(check()) {
            min = Math.min(min, depth);
            return;
        }


        int[] copy = new int[W];

        for(int i=idx; i<D; i++) {
            // copy 복사
            for(int t=0; t<W; t++)
                copy[t] = film[i][t];

            drugOn(0, i);
            DFS(depth+1, i+1);

            drugOn(1, i);
            DFS(depth+1, i+1);

            // 원본 복사
            for(int t=0; t<W; t++)
                film[i][t] = copy[t];
        }
    }

    public static void drugOn(int drugType, int i) {
        for(int j=0; j<W; j++)
            film[i][j] = drugType;
    }
}
