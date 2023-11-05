package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_4358_생태학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> map = new HashMap<>();

        int size = 0;
        String name = "";

        while((name = br.readLine()) != null) {
            size++;

            if(map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            }
            else
                map.put(name, 1);
        }

        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            list.add(str);
        }

        Collections.sort(list);

        for (String s : list) {
            int cnt = map.get(s) * 100;
            System.out.println(s + " " + String.format("%.4f", (double)cnt / (double)size));
        }
    }
}
