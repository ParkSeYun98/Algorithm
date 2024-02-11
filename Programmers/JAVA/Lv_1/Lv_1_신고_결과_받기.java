package Programmers.JAVA.Lv_1;

import java.util.*;

public class Lv_1_신고_결과_받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> idxMap = new HashMap<>();
        int[] mailCnt = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            idxMap.put(id_list[i], i);
        }

        for (String reportInfo : report) {
            String sender = reportInfo.split(" ")[0];
            String receiver = reportInfo.split(" ")[1];

            map.get(receiver).add(sender);
        }

        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> senderSet = map.get(id_list[i]);

            if (senderSet.size() >= k) {
                for (String sender : senderSet)
                    mailCnt[idxMap.get(sender)]++;
            }
        }

        return mailCnt;
    }
}