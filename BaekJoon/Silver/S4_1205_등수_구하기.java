package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S4_1205_등수_구하기 {

    static int N, newScore, P;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        if(N != 0) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int i=0; i<N; i++)
                list.add(Integer.parseInt(st.nextToken()));
        }

        if(N == 0) {
            System.out.println(1);
            return;
        }

        Collections.sort(list, Collections.reverseOrder());

        if(N == P && newScore <= list.get(list.size()-1)) {
            System.out.println(-1);
            return;
        }

        int ans = 1;

        for(int i=0; i<list.size(); i++) {
            if (newScore < list.get(i))
                ans++;
            else
                break;
        }

        System.out.println(ans);
    }
}
