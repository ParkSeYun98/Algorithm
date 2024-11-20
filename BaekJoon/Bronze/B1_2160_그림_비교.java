package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_2160_그림_비교 {

    static int N;

    static int[] arr;

    static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][5][7];

        for(int i=0; i<N; i++) {
            for(int j=0; j<5; j++) {
                String a = br.readLine();

                for(int k=0; k<7; k++)
                    map[i][j][k] = a.charAt(k);
            }
        }

        int cnt = 0;

        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                cnt = 0;

                for(int x=0; x<5; x++) {
                    for(int y=0; y<7; y++) {
                        if(map[i][x][y] != map[j][x][y])
                            cnt++;
                    }
                }
                if(cnt < min) {
                    min = cnt;
                    a = i+1;
                    b = j+1;
                }
            }
        }

        System.out.println(a + " " + b);
    }
}
