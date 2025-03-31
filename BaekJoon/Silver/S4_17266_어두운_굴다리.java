package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_17266_어두운_굴다리 {

    static int N, M;

    static int[] light;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        light = new int[M];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++)
            light[i] = Integer.parseInt(st.nextToken());

        BinarySearch();
    }

    static void BinarySearch() {
        int result = 0;
        int start = 1;
        int end = N;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(isOK(mid)) {
                end = mid - 1;
                result = mid;
            }
            else
                start = mid + 1;
        }

        System.out.println(result);
    }

    static boolean isOK(int height) {
        int idx = 0;

        for (int i=0; i<light.length; i++) {
            if (light[i] - height <= idx)
                idx = light[i] + height;
            else
                return false;
        }

        return N <= idx;
    }
}
