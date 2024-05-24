package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B2_2747_피보나치_수 {

    static int n;

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        list.add(0);
        list.add(1);

        for(int i=2; i<=n; i++)
            list.add(list.get(i-2) + list.get(i-1));

        System.out.println(list.get(n));
    }
}
