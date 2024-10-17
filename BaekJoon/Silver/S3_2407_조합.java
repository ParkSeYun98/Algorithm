package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class S3_2407_조합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger A = BigInteger.ONE;
        BigInteger B = BigInteger.ONE;

        for(int i=0; i<m; i++) {
            A = A.multiply(new BigInteger(String.valueOf((n-i))));
            B = B.multiply(new BigInteger(String.valueOf((i+1))));
        }

        BigInteger result = A.divide(B);

        System.out.println(result);
    }
}
