/*
* Memory : 14388 KB
* Time : 132 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_20044_Project_Teams {

    private static int n;

    private static int[] codingPower;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        codingPower = new int[2*n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<2*n; i++)
            codingPower[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(codingPower);

        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++)
            min = Math.min(min, codingPower[i] + codingPower[codingPower.length-i-1]);

        System.out.println(min);
    }
}
