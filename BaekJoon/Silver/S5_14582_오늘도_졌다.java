/*
* Memory : 11472 KB
* Time : 76 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_14582_오늘도_졌다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] teamA = new int[9];
        int[] teamB = new int[9];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<teamA.length; i++)
            teamA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<teamB.length; i++)
            teamB[i] = Integer.parseInt(st.nextToken());

        int cntA = 0;
        int cntB = 0;

        for(int i=0; i<teamA.length; i++) {
            cntA += teamA[i];

            if((cntA > cntB)) {
                System.out.println("Yes");
                return;
            }

            cntB += teamB[i];
        }

        System.out.println("No");
    }
}
