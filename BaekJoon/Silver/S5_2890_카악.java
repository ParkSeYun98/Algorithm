package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_2890_카악 {

    static int R, C;

    static char[][] picture;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        picture = new char[R][C];

        for(int i=0; i<R; i++) {
            String input = br.readLine();

            for(int j=0; j<C; j++)
                picture[i][j] = input.charAt(j);
        }

        getRank();
    }

    static void getRank() {
        boolean[] visited = new boolean[R+1];
        int[] rank = new int[R+1];

        int idx = 1;

        for(int i=C-2; i>=1; i--) {
            boolean flag = false;

            for(int j=0; j<R; j++) {
                if(!visited[j] && picture[j][i] != '.') {
                    visited[j] = true;
                    rank[picture[j][i] - '0'] = idx;
                    flag = true;
                }
            }

            if(flag)
                idx++;
        }

        for(int i=1; i<rank.length; i++)
            if(rank[i] != 0)
                System.out.println(rank[i]);
    }
}
