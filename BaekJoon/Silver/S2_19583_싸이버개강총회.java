/*
* Memory : 95420 KB
* Time : 560 ms
* */

package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_19583_싸이버개강총회 {

    private static int cnt = 0;

    private static final Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();

        String temp;

//        for(int i=0; i<17; i++) {
//            temp = br.readLine();
        while((temp = br.readLine()) != null) {
            String[] splitStrArr = temp.split(" ");

            int time = changeToMinutes(splitStrArr[0]);

            if(time <= changeToMinutes(S))
                set.add(splitStrArr[1]);

            else if(time >= changeToMinutes(E) && time <= changeToMinutes(Q)) {
                if(set.contains(splitStrArr[1])) {
                    cnt ++;
                    set.remove(splitStrArr[1]);
                }
            }
        }

        System.out.println(cnt);
    }

    public static int changeToMinutes(String str) {
        int hour = Integer.parseInt(str.substring(0, 2));
        int min = Integer.parseInt(str.substring(3, 5));

        return ((hour * 60) + min);
    }
}
