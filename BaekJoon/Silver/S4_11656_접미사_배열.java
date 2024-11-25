package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_11656_접미사_배열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        List<String> list = new ArrayList<>();

        for(int i=0; i<S.length(); i++) {
            String temp = "";

            for(int j=i; j<S.length(); j++)
                temp += S.charAt(j);

            list.add(temp);
        }

        Collections.sort(list);

        for (String str : list)
            System.out.println(str);
    }
}
