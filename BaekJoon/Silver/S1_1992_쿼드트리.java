package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1992_쿼드트리 {
    private static int N;
    private static String result="";

    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                arr[i][j] = input.charAt(j) - '0';
        }

        divide(0, 0, N);

        System.out.println(result);
    }

    public static void divide(int x, int y, int size) {
        if(conquer(x, y, size)) {
            result += arr[x][y];
            return;
        }

        int dividedSize = size / 2;

        result += "(";

        divide(x, y, dividedSize);
        divide(x, y+dividedSize, dividedSize);
        divide(x+dividedSize, y, dividedSize);
        divide(x+dividedSize, y+dividedSize, dividedSize);

        result += ")";
    }

    public static boolean conquer(int x, int y, int size) {
        for(int i=x; i<x+size; i++) {
            for(int j=y; j<y+size; j++) {
                if(arr[x][y] != arr[i][j])
                    return false;
            }
        }

        return true;
    }
}
