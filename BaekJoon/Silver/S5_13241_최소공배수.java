package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_13241_최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        System.out.println(lcm(A, B));
    }

    static long lcm(long a, long b) {
        long gcd = gcd(a, b);

        return (a*b) / gcd;
    }

    static long gcd(long a, long b) {
        if(b == 0)
            return a;
        else
            return gcd(b, a%b);
    }
}
