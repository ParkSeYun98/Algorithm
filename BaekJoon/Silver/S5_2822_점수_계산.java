package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_2822_점수_계산 {

    static List<Integer> scoreList;

    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        scoreList = new ArrayList<>();
        map = new HashMap<>();

        for(int i=0; i<8; i++) {
            int now = Integer.parseInt(br.readLine());

            scoreList.add(now);
            map.put(now, i+1);
        }

        scoreList.sort(Collections.reverseOrder());

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> temp = new ArrayList<>();

        for(int i=0; i<5; i++) {
            int now = scoreList.get(i);

            sum += now;
            temp.add(map.get(now));
        }

        Collections.sort(temp);

        for (Integer num : temp)
            sb.append(num).append(" ");

        System.out.println(sum);
        System.out.println(sb);
    }
}
