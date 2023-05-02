package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B3_2576_홀수 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<7; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input%2 == 1)
                list.add(input);
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (Integer i : list) {
            sum += i;
            min = Math.min(min, i);
        }

        if(list.size() == 0)
            System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
