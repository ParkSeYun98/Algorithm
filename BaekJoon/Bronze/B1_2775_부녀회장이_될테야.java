package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_2775_부녀회장이_될테야 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] house = new int[k+1][n+1];

            for(int i=1; i<n+1; i++)
                house[0][i] = i;

            for(int i=1; i<house.length; i++) {
                for(int j=1; j<house[i].length; j++) {
                    int sum = 0;

                    for(int a=1; a<=j; a++)
                        sum += house[i-1][a];

                    house[i][j] = sum;
                }
            }

            System.out.println(house[k][n]);
        }
    }
}
