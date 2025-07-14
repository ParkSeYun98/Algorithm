package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_20920_영단어_암기는_괴로워 {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> vocaMap = new HashMap<>();

        for(int i=0; i<N; i++) {
            String now = br.readLine();

            if(now.length() >= M) {
                if(!vocaMap.containsKey(now))
                    vocaMap.put(now, 1);
                else
                    vocaMap.put(now, vocaMap.get(now)+1);
            }
        }

        List<Map.Entry<String, Integer>> vocaList = new ArrayList<>(vocaMap.entrySet());
        vocaList.sort((o1, o2) -> {
            if(!o1.getValue().equals(o2.getValue()))
                return o2.getValue() - o1.getValue();

            if(o1.getKey().length() != o2.getKey().length())
                return o2.getKey().length() - o1.getKey().length();

            return o1.getKey().compareTo(o2.getKey());
        });

        for (Map.Entry<String, Integer> entry : vocaList)
            System.out.println(entry.getKey());
    }
}
