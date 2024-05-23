package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_16926_배열_돌리기_1 {

    static int N, M, R;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<R; i++)
            rotate();

        print();
    }

    static void rotate() {
        for(int layer=0; layer<Math.min(N, M)/2; layer++) {
            int temp = arr[layer][layer];

            for(int i=layer; i<M-layer-1; i++)
                arr[layer][i] = arr[layer][i+1];

            for(int i=layer; i<N-layer-1; i++)
                arr[i][M-layer-1] = arr[i+1][M-layer-1];

            for(int i=M-layer-1; i>layer; i--)
                arr[N-layer-1][i] = arr[N-layer-1][i-1];

            for(int i=N-layer-1; i>layer; i--)
                arr[i][layer] = arr[i-1][layer];

            arr[layer+1][layer] = temp;
        }
    }

    static void print() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
