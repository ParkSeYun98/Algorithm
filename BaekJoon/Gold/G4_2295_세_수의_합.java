package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_2295_세_수의_합 {

    static int N;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        int[] sum = new int[N*(N+1)/2];
        int idx = 0;

        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++)
                sum[idx++] = arr[i] + arr[j];
        }

        Arrays.sort(sum);

        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int minus = arr[i] - arr[j];

                if(binarySearch(sum, minus))
                    max = Math.max(max, arr[i]);
            }
        }

        System.out.println(max);
    }

    static boolean binarySearch(int[] sum, int minus) {
        int left = 0;
        int right = sum.length-1;

        while(left <= right) {
            int mid = (left+right) / 2;

            if(sum[mid] > minus)
                right = mid - 1;
            else if(sum[mid] < minus)
                left = mid + 1;
            else
                return true;
        }

        return false;
    }
}
