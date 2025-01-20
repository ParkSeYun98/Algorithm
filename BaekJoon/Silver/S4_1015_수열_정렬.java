package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1015_수열_정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(st.nextToken());
            A[i] = input;
            B[i] = input;
        }

        Arrays.sort(B);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(A[i] == B[j]) {
                    System.out.print(j + " ");
                    B[j] = -1;
                    break;
                }
            }
        }
    }
}
