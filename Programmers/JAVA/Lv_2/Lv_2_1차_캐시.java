package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_1차_캐시 {

    static int HIT = 1;
    static int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>();

        int time = 0;

        if(cacheSize == 0)
            return cities.length * MISS;

        for (String city : cities) {
            String now = city.toLowerCase();

            if (cache.contains(now)) {
                time += HIT;

                cache.remove(now);
                cache.add(now);
            } else {
                time += MISS;

                if (cache.size() >= cacheSize)
                    cache.remove(0);

                cache.add(now);
            }
        }

        return time;
    }
}
