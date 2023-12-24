/*
* Memory : 12808 KB
* Time : 96 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_18230_2xN_예쁜_타일링 {

    private static int N;
    private static int A;
    private static int B;

    private static int[] tileA;
    private static int[] tileB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        tileA = new int[A];
        tileB = new int[B];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<A; i++)
            tileA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<B; i++)
            tileB[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(tileA);
        Arrays.sort(tileB);

        getMaxBeauty();
    }

    public static void getMaxBeauty() {
        int beauty = 0;
        int Acnt = 0;
        int Bcnt = 0;

        if(N/2 > B)
            Bcnt = B;
        else
            Bcnt = N/2;

        Acnt = N - (2 * Bcnt);

        for(int i=1; i<=Acnt; i++)
            beauty += tileA[A - i];

        for(int i=1; i<=Bcnt; i++)
            beauty += tileB[B - i];

        int AIdx = 0;

        for(int i=0; i<Bcnt; i++) {
            if(A-Acnt-AIdx < 2)
                break;

            if(tileB[B-Bcnt+i] < tileA[A-Acnt-AIdx-1] + tileA[A-Acnt-AIdx-2]) {
                beauty -= tileB[B-Bcnt+i];
                beauty += (tileA[A-Acnt-AIdx-1] + tileA[A-Acnt-AIdx-2]);
                AIdx += 2;
            }
        }

        System.out.println(beauty);
    }
}
