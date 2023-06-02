package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B5_5597_과제_안_내신_분 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[31];

        for(int i=1; i<=28; i++)
            arr[Integer.parseInt(br.readLine())]++;

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<arr.length; i++) {
            if(arr[i] == 0)
                list.add(i);
        }

        for (Integer integer : list)
            System.out.println(integer);
    }
}
