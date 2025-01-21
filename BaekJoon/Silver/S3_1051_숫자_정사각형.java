package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1051_숫자_정사각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                square[i][j] = input.charAt(j) - '0';
        }

        int maxLength = Math.min(N, M);

        while(maxLength > 1) {
            for(int i=0; i<=N-maxLength; i++) {
                for(int j=0; j<=M-maxLength; j++) {
                    int now = square[i][j];

                    if(now==square[i][j+maxLength-1] && now==square[i+maxLength-1][j] && now==square[i+maxLength-1][j+maxLength-1]) {
                        System.out.println(maxLength*maxLength);
                        return;
                    }
                }
            }

            maxLength--;
        }

        System.out.println(maxLength * maxLength);
    }
}
