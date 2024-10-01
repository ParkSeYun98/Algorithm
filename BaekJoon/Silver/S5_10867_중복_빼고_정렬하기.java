package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_10867_중복_빼고_정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            set.add(Integer.parseInt(st.nextToken()));

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        for (Integer now : list)
            System.out.print(now + " ");
    }
}
