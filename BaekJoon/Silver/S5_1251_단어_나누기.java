package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S5_1251_단어_나누기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String voca = br.readLine();

        List<String> list = new ArrayList<>();

        for(int i=1; i<voca.length(); i++) {
            for(int j=i+1; j<voca.length(); j++)
                list.add(makeVoca(voca, i, j));
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }

    static String makeVoca(String voca, int i, int j) {
        StringBuilder sb1 = new StringBuilder(voca.substring(0, i));
        StringBuilder sb2 = new StringBuilder(voca.substring(i, j));
        StringBuilder sb3 = new StringBuilder(voca.substring(j));

        StringBuilder sb = new StringBuilder();
        sb.append(sb1.reverse()).append(sb2.reverse()).append(sb3.reverse());

        return sb.toString();
    }
}
