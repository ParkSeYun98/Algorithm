package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        int pointerA = 0;
        int pointerB = 0;
        int sum = 0;

        while(true) {
            if(pointerA >= N+1 || pointerB>=N+1)
                break;

            if(sum >= S) {
                min = Math.min(min, pointerB-pointerA);
                sum -= arr[pointerA++];
            }
            else
                sum += arr[pointerB++];
        }

        if(min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}
