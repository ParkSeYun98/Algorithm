package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S5_2635_수_이어가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        List<Integer> maxList = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(N);
            list.add(i);

            while(true) {
                int now = list.get(list.size()-2) - list.get(list.size()-1);

                if(now >= 0)
                    list.add(now);
                else
                    break;
            }

            if(max < list.size()) {
                max = list.size();
                maxList = list;
            }
        }

        System.out.println(max);

        for (Integer now : maxList)
            System.out.print(now + " ");
    }
}
