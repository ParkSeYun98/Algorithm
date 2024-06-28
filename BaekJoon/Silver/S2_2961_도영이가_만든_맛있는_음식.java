package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2961_도영이가_만든_맛있는_음식 {

    static int N, min;

    static int[] sour, bitter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        sour = new int[N];
        bitter = new int[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        makeFood(0, 1, 0, 0);

        System.out.println(min);
    }

    static void makeFood(int depth, int sourCnt, int bitterCnt, int selectCnt) {
        if(depth == N) {
            if(selectCnt >= 1 && Math.abs(sourCnt - bitterCnt) < min)
                min = Math.abs(sourCnt - bitterCnt);

            return;
        }

        makeFood(depth+1, sourCnt * sour[depth], bitterCnt + bitter[depth], selectCnt+1);
        makeFood(depth+1, sourCnt, bitterCnt, selectCnt);
    }
}
