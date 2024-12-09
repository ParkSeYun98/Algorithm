package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S2_1411_비슷한_단어 {

    static int N, cnt;

    static String[] voca;
    static int[] numArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        cnt = 0;
        voca = new String[N];
        numArr = new int[2];

        for(int i=0; i<N; i++)
            voca[i] = transform(br.readLine());

        combination(0, 0);

        System.out.println(cnt);
    }

    static void combination(int depth, int start) {
        if(depth >= 2) {
            if(voca[numArr[0]].equals(voca[numArr[1]]))
                cnt++;

            return;
        }

        for(int i=start; i<N; i++) {
            numArr[depth] = i;
            combination(depth+1, i+1);
        }
    }

    static String transform(String input) {
        Map<Character, Character> map = new HashMap<>();

        char ch = 'a';
        String temp = "";

        for(int i=0; i<input.length(); i++) {
            char now = input.charAt(i);

            if(!map.containsKey(now))
                map.put(now, (char)(ch++));

            temp += map.get(now);
        }

        return temp;
    }
}
