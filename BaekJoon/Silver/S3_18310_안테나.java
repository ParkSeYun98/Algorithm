package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_18310_안테나 {

    static int N;

    static int[] place;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        place = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++)
            place[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(place);

        if(N%2 == 0)
            System.out.println(place[N/2 - 1]);
        else
            System.out.println(place[N/2]);
    }
}
