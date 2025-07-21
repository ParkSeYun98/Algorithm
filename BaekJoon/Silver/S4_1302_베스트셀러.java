package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_1302_베스트셀러 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = 0;

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            if(map.containsKey(input))
                map.put(input, map.get(input)+1);
            else
                map.put(input, 1);

            max = Math.max(max, map.get(input));
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(max == entry.getValue())
                list.add(entry.getKey());
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
