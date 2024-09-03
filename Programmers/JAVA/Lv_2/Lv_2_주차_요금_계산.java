package Programmers.JAVA.Lv_2;

import java.util.*;

public class Lv_2_주차_요금_계산 {

    public class Parking {
        int time;
        String carNum;

        public Parking(int time, String carNum) {
            this.time = time;
            this.carNum = carNum;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        List<Parking> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<records.length; i++) {
            String now = records[i];

            String[] record = now.split(" ");
            String[] time = record[0].split(":");
            int minute = 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]);

            if(record[2].equals("IN"))
                list.add(new Parking(minute, record[1]));
            else {
                for(int j=0; j<list.size(); j++) {
                    if(list.get(j).carNum.equals(record[1])) {
                        Parking park = list.remove(j);
                        int diff = minute - park.time;

                        if(map.containsKey(record[1]))
                            map.put(record[1], map.get(record[1]) + diff);
                        else
                            map.put(record[1], diff);
                    }
                }
            }
        }


        for(int i=0; i<list.size(); i++) {
            Parking now = list.get(i);
            int diff = (60*23 + 59) - now.time;

            if(map.containsKey(now.carNum))
                map.put(now.carNum, map.get(now.carNum) + diff);
            else
                map.put(now.carNum, diff);
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        Collections.sort(keyList);

        int[] result = new int[keyList.size()];

        for(int i=0; i<keyList.size(); i++) {
            int minute = map.get(keyList.get(i));

            result[i] = fees[1];

            if(minute > fees[0]) {
                if((minute - fees[0]) % fees[2] == 0)
                    result[i] += ((minute - fees[0]) / fees[2]) * fees[3];
                else
                    result[i] += ((minute - fees[0]) / fees[2] + 1) * fees[3];
            }
        }

        return result;
    }
}
