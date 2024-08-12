package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class S2_15501_부당한_퍼즐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] input = new int[N];
        int[] output = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            input[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            output[i] = Integer.parseInt(st.nextToken());

        boolean flagA = true, flagB = true;

        for(int idx=0; idx<N; idx++){
            if(input[0] != output[idx])
                continue;

            for(int i=0; i<N; i++){
                if(input[i]==output[(idx+i)%N]) continue;
                flagA = false;
                break;
            }

            for(int i=0; i<N; i++){
                if(input[i] == output[(idx+N-i)%N]) continue;
                flagB = false;
                break;
            }

            if(flagA || flagB)
                System.out.println("good puzzle");
            else
                System.out.println("bad puzzle");

            return;
        }
    }
}
