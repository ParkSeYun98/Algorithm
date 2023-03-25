package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1629_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(Calc(A, B, C));
    }

    public static long Calc(long A, long B, long C) {
        if(B == 1)
            return A % C;

        long temp = Calc(A, B/2, C);

        if(B % 2 == 1)
            return (temp * temp % C) * A % C;
        return temp * temp % C;
    }
}
