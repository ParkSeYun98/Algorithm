/*
* Memory : 18388 KB
* Time : 288 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1_8980_택배 {

    static int N;
    static int C;
    static int M;
    static int result;

    static Baggage[] baggageArr;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        baggageArr = new Baggage[M+1];

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int boxCnt = Integer.parseInt(st.nextToken());

            baggageArr[i] = new Baggage(start, end, boxCnt);
        }

        Arrays.sort(baggageArr, 1, baggageArr.length);

        weight = new int[N+1];
        Arrays.fill(weight, C);

        result = 0;

        for(int i=1; i<=M; i++) {
            Baggage baggage = baggageArr[i];

            int maxBoxCnt = Integer.MAX_VALUE;

            for(int j=baggage.start; j<baggage.end; j++)
                maxBoxCnt = Math.min(maxBoxCnt, weight[j]);

            if(maxBoxCnt >= baggage.boxCnt) {
                for(int j=baggage.start; j<baggage.end; j++)
                    weight[j] -= baggage.boxCnt;

                result += baggage.boxCnt;
            }
            else {
                for(int j=baggage.start; j<baggage.end; j++)
                    weight[j] -= maxBoxCnt;

                result += maxBoxCnt;
            }
        }

        System.out.println(result);
    }

    static class Baggage implements Comparable<Baggage>{
        int start;
        int end;
        int boxCnt;

        public Baggage(int start, int end, int boxCnt) {
            this.start = start;
            this.end = end;
            this.boxCnt = boxCnt;
        }

        @Override
        public int compareTo(Baggage o) {
            if(this.end == o.end)
                return this.start - o.start;

            return this.end - o.end;
        }
    }
}
