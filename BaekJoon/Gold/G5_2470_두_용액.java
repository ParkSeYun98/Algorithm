/*
* Memory : 31456 KB
* Time : 300 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470_두_용액 {

    static int N;

    static int[] liquid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        liquid = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            liquid[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(liquid);

        BinarySearch();
    }

    static void BinarySearch() {
        int start = 0;
        int end = liquid.length-1;
        int finalLiquidA = -1;
        int finalLiquidB = -1;
        int min = Integer.MAX_VALUE;

        while(start < end) {
            int sum = liquid[start] + liquid[end];

            if(min > Math.abs(sum)) {
                min = Math.abs(sum);

                finalLiquidA = liquid[start];
                finalLiquidB = liquid[end];

                if(sum == 0)
                    break;
            }

            if(sum > 0)
                end--;
            else if(sum < 0)
                start++;
            else
                break;
        }

        System.out.println(finalLiquidA + " " + finalLiquidB);
    }
}
