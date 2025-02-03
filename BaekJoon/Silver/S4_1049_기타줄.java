package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1049_기타줄 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int pack = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            one = Math.min(one, Integer.parseInt(st.nextToken()));
        }

        int min = Integer.MAX_VALUE;

        min = Math.min(min, pack*((N/6)+1));
        min = Math.min(min, one*N);
        min = Math.min(min, pack*(N/6) + one*(N%6));

        System.out.println(min);
    }
}
