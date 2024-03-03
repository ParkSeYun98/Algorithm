/*
* Memory : 51748 KB
* Time : 464 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S3_2012_등수_매기기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] expectedRank = new int[N+1];

        for(int i=0; i<N; i++)
            expectedRank[i] = Integer.parseInt(br.readLine());

        Arrays.sort(expectedRank);

        long sum = 0;

        for(int i=1; i<expectedRank.length; i++)
            sum += Math.abs(i - expectedRank[i]);

        System.out.println(sum);
    }
}
