package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_2870_수학숙제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<BigInteger> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            String temp = "";

            for(int j=0; j<input.length(); j++) {
                char now = input.charAt(j);

                if(now>=48 && now<=57)
                    temp += now;
                else {
                    if(!temp.isEmpty())
                        list.add(new BigInteger(temp));

                    temp = "";
                }
            }

            if(!temp.isEmpty())
                list.add(new BigInteger(temp));
        }

        Collections.sort(list);

        for (BigInteger now : list)
            System.out.println(now);
    }
}
