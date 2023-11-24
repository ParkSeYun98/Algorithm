/*
* Memory : 314516 KB
* Time : 4496 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S3_1270_전쟁_땅따먹기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());

            for(int j=0; j<size; j++) {
                Long temp = Long.parseLong(st.nextToken());

                if(map.containsKey(temp))
                    map.put(temp, map.get(temp) + 1);
                else
                    map.put(temp, 1);
            }

            long result = 0;

            for(Map.Entry<Long, Integer> entry : map.entrySet()) {
                if(entry.getValue() > size/2)
                    result = entry.getKey();
            }

            if(result != 0)
                System.out.println(result);
            else
                System.out.println("SYJKGW");

            map.clear();
        }
    }
}
