package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_1138_한_줄로_서기 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        int[] answer = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=1; i<=N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) {
            int idx = 1;

            while(true) {
                if(arr[i]==0 && answer[idx]==0) {
                    answer[idx] = i;
                    break;
                }
                else if(answer[idx]==0)
                    arr[i]--;

                idx++;
            }
        }

        for(int i=1; i<=N; i++)
            System.out.print(answer[i] + " ");
    }
}
