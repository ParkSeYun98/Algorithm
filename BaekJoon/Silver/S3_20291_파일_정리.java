package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3_20291_파일_정리 {

    static int N;

    static Map<String, Integer> map;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            String A = st.nextToken();
            String B = st.nextToken();

            if(!map.containsKey(B)) {
                map.put(B, 1);
                list.add(B);
            }
            else
                map.put(B, map.get(B)+1);
        }

        Collections.sort(list);

        for (String str : list)
            System.out.println(str + " " + map.get(str));
    }
}
