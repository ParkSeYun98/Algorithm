package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class S3_4375_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        while((input = br.readLine()) != null) {
            BigInteger n = new BigInteger(input);
            BigInteger base = BigInteger.ZERO;

            while(true) {
                base = base.multiply(BigInteger.TEN).add(BigInteger.ONE);

                if(base.mod(n).equals(BigInteger.ZERO)) {
                    System.out.println(base.toString().length());
                    break;
                }
            }
        }
    }
}
