package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_1267_핸드폰_요금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] calls = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
             calls[i] = Integer.parseInt(st.nextToken());

        int yCnt = YoungSik(calls);
        int mCnt = MinSik(calls);

        if(yCnt == mCnt)
            System.out.println("Y M " + yCnt);
        else if(yCnt > mCnt)
            System.out.println("M " + mCnt);
        else
            System.out.println("Y " + yCnt);
    }

    static int YoungSik(int[] calls) {
        int sum = 0;

        for(int i=0; i<calls.length; i++)
            sum += ((calls[i] / 30) + 1) * 10;

        return sum;
    }

    static int MinSik(int[] calls) {
        int sum = 0;

        for(int i=0; i<calls.length; i++)
            sum += ((calls[i] / 60) + 1) * 15;

        return sum;
    }
}
