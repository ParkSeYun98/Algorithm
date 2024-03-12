/*
* Memory : 144204 KB
* Time : 976 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_10815_숫자_카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] cardArrA = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            cardArrA[i] = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        int[] cardArrB = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++)
            cardArrB[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cardArrA);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<cardArrB.length; i++) {
            if(binarySearch(cardArrB[i], N, cardArrA))
                sb.append(1);
            else
                sb.append(0);

            sb.append(" ");
        }

        System.out.println(sb);
    }

    static boolean binarySearch(int target, int N, int[] cardArrA) {
        int left = 0;
        int right = N-1;

        while(left <= right) {
            int mid = (left+right)/2;

            if(target < cardArrA[mid])
                right = mid - 1;
            else if(target > cardArrA[mid])
                left = mid + 1;
            else
                return true;
        }

        return false;
    }
}
