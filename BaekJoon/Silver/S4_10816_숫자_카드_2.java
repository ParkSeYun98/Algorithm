package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class S4_10816_숫자_카드_2 {
    static int N;

    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cards = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(UpperBoundBinarySearch(key) - LowerBoundBinarySearch(key)).append(" ");
        }

        System.out.println(sb);
    }

    static int LowerBoundBinarySearch(int key) {
        int left = 0;
        int right = cards.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(key <= cards[mid])
                right = mid;
            else
                left = mid+1;
        }

        return left;
    }

    static int UpperBoundBinarySearch(int key) {
        int left = 0;
        int right = cards.length;

        while(left < right) {
            int mid = (left + right) / 2;

            if(key < cards[mid])
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}
