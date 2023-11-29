/*
* Memory : 41432 KB
* Time : 388 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_13305_주유소 {

    private static long total = 0;

    private static long[] roadArr;
    private static long[] priceArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        roadArr = new long[N-1];
        priceArr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<roadArr.length; i++)
            roadArr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<priceArr.length; i++)
            priceArr[i] = Integer.parseInt(st.nextToken());

        getMinimumCost();

        System.out.println(total);
    }

    public static void getMinimumCost() {
        long minimumPrice = priceArr[0];

        for(int i=0; i<priceArr.length - 1; i++) {
            minimumPrice = Math.min(minimumPrice, priceArr[i]);

            total += minimumPrice * roadArr[i];
        }
    }
}
