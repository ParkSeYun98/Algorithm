package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_2828_사과_담기_게임 {

    static int N, M, J;

    static int[] dropPoint;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());

        dropPoint = new int[J];

        for(int i=0; i<J; i++)
            dropPoint[i] = Integer.parseInt(br.readLine());

        drop();
    }

    static void drop() {
        int start = 1;
        int end = M;
        int cnt = 0;

        for(int i=0; i<J; i++) {
            if(start > dropPoint[i]) {
                cnt += (start - dropPoint[i]);
                end -= (start - dropPoint[i]);
                start = dropPoint[i];
            }
            else if(end < dropPoint[i]) {
                cnt += (dropPoint[i] - end);
                start += (dropPoint[i] - end);
                end = dropPoint[i];
            }
        }

        System.out.println(cnt);
    }
}
