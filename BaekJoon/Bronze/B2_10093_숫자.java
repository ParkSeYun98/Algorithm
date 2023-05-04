package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_10093_숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        if(Math.abs(A-B)-1 < 0)
            System.out.println(0);
        else
            System.out.println(Math.abs(A-B)-1);

        if(A<=B) {
            for(long i=A+1; i<B; i++)
                System.out.print(i + " ");
        }
        else {
            for(long i=B+1; i<A; i++)
                System.out.print(i + " ");
        }
    }
}
