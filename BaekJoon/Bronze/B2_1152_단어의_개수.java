package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2_1152_단어의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<java.lang.String> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens())
            list.add(st.nextToken());

        System.out.println(list.size());
    }
}
