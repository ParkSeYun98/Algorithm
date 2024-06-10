package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_1764_듣보잡 {

    static int N, M;

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
            set.add(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i=0; i<M; i++) {
            String input = br.readLine();

            if(set.contains(input))
                list.add(input);
        }

        Collections.sort(list);

        System.out.println(list.size());

        for (String str : list)
            System.out.println(str);
    }
}
