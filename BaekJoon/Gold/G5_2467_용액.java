package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            liquid[i] = Integer.parseInt(st.nextToken());

        int pointerA = 0;
        int pointerB = N-1;
        int resultA = -1;
        int resultB = -1;
        int min = Integer.MAX_VALUE;

        while (pointerA < pointerB) {

            int sum = liquid[pointerA] + liquid[pointerB];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                resultA = liquid[pointerA];
                resultB = liquid[pointerB];
            }

            if (sum >= 0)
                pointerB--;
            else
                pointerA++;
        }

        if(resultA > resultB)
            System.out.println(resultB + " " + resultA);
        else
            System.out.println(resultA + " " + resultB);
    }
}
