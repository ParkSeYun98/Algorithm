package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S3_11478_서로_다른_부분_문자열의_개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i=0; i<S.length(); i++) {
            for(int j=i+1; j<S.length()+1; j++)
                set.add(S.substring(i, j));
        }

        System.out.println(set.size());
    }
}
