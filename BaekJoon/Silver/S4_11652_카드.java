package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S4_11652_카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        int maxCnt = 0;
        long num = 0;

        for(int i=0; i<N; i++) {
            Long now = Long.parseLong(br.readLine());

            map.put(now, map.getOrDefault(now, 0) + 1);

            if(map.get(now) > maxCnt) {
                maxCnt = map.get(now);
                num = now;
            }
            else if(map.get(now) == maxCnt)
                num = Math.min(num, now);
        }

        System.out.println(num);
    }
}
