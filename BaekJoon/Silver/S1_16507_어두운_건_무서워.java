package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16507_어두운_건_무서워 {

    static int R, C, Q;

    static int[][] picture;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        picture = new int[R+1][C+1];

        for(int i=1; i<=R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1; j<=C; j++) {
                int input = Integer.parseInt(st.nextToken());

                picture[i][j] = picture[i-1][j] + picture[i][j-1] - picture[i-1][j-1] + input;
            }
        }

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int size = (r2-r1+1) * (c2-c1+1);

            System.out.println((picture[r2][c2]-picture[r1-1][c2]-picture[r2][c1-1]+picture[r1-1][c1-1]) / size);
        }


    }
}
