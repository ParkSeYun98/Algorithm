package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S5_11650_좌표_정렬하기 {

    private static int N;

    private static int[][] coOrdinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        coOrdinates = new int[N][2];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            coOrdinates[i][0] = Integer.parseInt(st.nextToken());
            coOrdinates[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coOrdinates, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++)
            sb.append(coOrdinates[i][0]).append(" ").append(coOrdinates[i][1]).append('\n');

        System.out.println(sb);
    }
}
