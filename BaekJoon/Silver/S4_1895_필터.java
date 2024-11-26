package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1895_필터 {

    static int R, C, T;

    static int[][] image, newImage;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        image = new int[R][C];
        newImage = new int[R-2][C-2];

        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<C; j++)
                image[i][j] = Integer.parseInt(st.nextToken());
        }

        T = Integer.parseInt(br.readLine());

        filtering();
    }

    static void filtering() {
        for(int i=0; i<R-2; i++) {
            for(int j=0; j<C-2; j++) {
                int[] arr = new int[9];
                int idx = 0;

                for(int a=i; a<i+3; a++) {
                    for(int b=j; b<j+3; b++)
                        arr[idx++] = image[a][b];
                }

                Arrays.sort(arr);

                newImage[i][j] = arr[4];
            }
        }

        int cnt = 0;

        for(int i=0; i<newImage.length; i++) {
            for(int j=0; j<newImage[i].length; j++) {
                if(newImage[i][j] >= T)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
