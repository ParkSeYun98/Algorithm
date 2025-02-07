package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_5648_역원소_정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];

        while(n > 0) {
            while(st.hasMoreTokens()) {
                String input = st.nextToken();
                String temp = "";

                for(int i=input.length()-1; i>=0; i--)
                    temp += input.charAt(i);

                arr[--n] = Long.parseLong(temp);
            }

            if(n > 0)
                st = new StringTokenizer(br.readLine(), " ");
        }

        Arrays.sort(arr);

        for (long now : arr)
            System.out.println(now);
    }
}
