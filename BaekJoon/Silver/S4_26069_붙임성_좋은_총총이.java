package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S4_26069_붙임성_좋은_총총이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String nameA = st.nextToken();
            String nameB = st.nextToken();

            if(set.contains(nameA) || set.contains(nameB)) {
                set.add(nameA);
                set.add(nameB);
            }
        }

        System.out.println(set.size());
    }
}
