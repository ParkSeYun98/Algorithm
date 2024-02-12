/*
* Memory : 32064 KB
* Time : 248 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_17406_배열_돌리기_4 {

    static int N, M, K, min;

    static int[] R, C, S, order;
    static boolean[] visited;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        R = new int[K];
        C = new int[K];
        S = new int[K];

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            R[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        order = new int[K];
        visited = new boolean[K];

        getOrder(0);

        System.out.println(min);
    }

    static void getOrder(int depth) {
        if(depth == K) {
            rotate();
            return;
        }

        for(int i=0; i<K; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                getOrder(depth+1);
                visited[i] = false;
            }
        }
    }

    static void rotate() {
        int[][] tempArr = copyArr();

        for(int o=0; o<order.length; o++) {
            int r = R[order[o]]-1;
            int c = C[order[o]]-1;

            for(int s=1; s<=S[order[o]]; s++) {
                // 윗쪽 줄
                int tempUp = tempArr[r-s][c+s];

                for(int i=c+s; i>c-s; i--)
                    tempArr[r-s][i] = tempArr[r-s][i-1];

                // 오른쪽 줄
                int tempRight = tempArr[r+s][c+s];

                for(int i=r+s; i>r-s; i--)
                    tempArr[i][c+s] = tempArr[i-1][c+s];

                tempArr[r-s+1][c+s] = tempUp;

                // 아래쪽 줄
                int tempDown = tempArr[r+s][c-s];

                for(int i=c-s; i<c+s; i++)
                    tempArr[r+s][i] = tempArr[r+s][i+1];

                tempArr[r+s][c+s-1] = tempRight;

                // 왼쪽 줄
                for(int i=r-s; i<r+s; i++)
                    tempArr[i][c-s] = tempArr[i+1][c-s];

                tempArr[r+s-1][c-s] = tempDown;
            }
        }

        int sum = getSum(tempArr);
        min = Math.min(min, sum);
    }

    static int[][] copyArr() {
        int[][] tempArr = new int[N][M];

        for(int i=0; i<arr.length; i++)
            tempArr[i] = arr[i].clone();

        return tempArr;
    }

    static int getSum(int[][] tempArr) {
        int tempMin = Integer.MAX_VALUE;

        for(int i=0; i<tempArr.length; i++) {
            int temp = 0;

            for(int j=0; j<tempArr[i].length; j++)
                temp += tempArr[i][j];

            tempMin = Math.min(tempMin, temp);
        }

        return tempMin;
    }
}
