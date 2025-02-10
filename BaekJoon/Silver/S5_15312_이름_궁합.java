package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S5_15312_이름_궁합 {

    static int[] num = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            list.add(num[a-'A']);
            list.add(num[b-'A']);
        }

        while(list.size() > 2) {
            List<Integer> tempList = new ArrayList<>();

            for(int i=0; i<list.size()-1; i++) {
                int a = list.get(i);
                int b = list.get(i+1);

                int sum = (a+b)%10;

                tempList.add(sum);
            }

            list = new ArrayList<>();

            for (Integer now : tempList)
                list.add(now);
        }

        System.out.println(list.get(0) + "" + list.get(1));
    }
}
