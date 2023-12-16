/*
* Memory : 38628 KB
* Time : 4836 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_14425_문자열_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++)
            list.add(br.readLine());

        int cnt = 0;

        for(int i=0; i<M; i++) {
            String temp = br.readLine();

            if(list.contains(temp))
                cnt++;
        }

        System.out.println(cnt);
    }
}
