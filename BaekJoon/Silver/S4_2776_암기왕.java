package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_2776_암기왕 {

    static int N1, N2;

    static int[] memo1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            N1 = Integer.parseInt(br.readLine());

            memo1 = new int[N1+1];
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N1; i++)
                memo1[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(memo1);

            N2 = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N2; i++)
                BinarySearch(Integer.parseInt(st.nextToken()), sb);

            System.out.println(sb);
        }
    }

    static void BinarySearch(int now, StringBuilder sb) {
        int left = 0;
        int right = N1;
        boolean flag = false;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(memo1[mid] == now) {
                flag = true;
                break;
            }
            else if(memo1[mid] < now)
                left = mid + 1;
            else
                right = mid - 1;
        }

        sb.append(flag? 1 : 0).append("\n");
    }
}
