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

            if(now.length() >= M)
                vocaMap.put(now, vocaMap.getOrDefault(now, 0) + 1);
        }

        List<String> vocaList = new ArrayList<>(vocaMap.keySet());

        vocaList.sort((o1, o2) -> {
            if(!vocaMap.get(o1).equals(vocaMap.get(o2)))
                return vocaMap.get(o2) - vocaMap.get(o1);

            if(o1.length() != o2.length())
                return o2.length() - o1.length();

            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();

        for (String now : vocaList)
            sb.append(now).append("\n");

        System.out.println(sb);
    }
}
