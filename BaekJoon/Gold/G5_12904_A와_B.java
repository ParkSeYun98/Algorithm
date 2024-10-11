package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_12904_A와_B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sbS = new StringBuilder(S);
        StringBuilder sbT = new StringBuilder(T);

        while(sbS.length() < sbT.length()) {
            char check = sbT.charAt(sbT.length()-1);

            sbT.deleteCharAt(sbT.length()-1);

            if(check == 'B')
                sbT.reverse();
        }

        System.out.println(sbS.toString().contentEquals(sbT) ? 1 : 0);
    }
}
