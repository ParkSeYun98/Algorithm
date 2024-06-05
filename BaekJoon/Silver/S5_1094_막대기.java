package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S5_1094_막대기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        list.add(64);

        while(true) {
            int sum2 = 0;

            for (Integer i : list)
                sum2 += i;

            if(sum2 <= X)
                break;

            Collections.sort(list);

            int half = list.get(0) / 2;

            list.remove(0);

            int sum = 0;

            for (Integer i : list)
                sum += i;

            list.add(half);

            if((sum + half) < X)
                list.add(half);
        }

        System.out.println(list.size());
    }
}
