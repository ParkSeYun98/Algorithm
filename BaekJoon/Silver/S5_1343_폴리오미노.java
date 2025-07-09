package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S5_1343_폴리오미노 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        List<String> list = new ArrayList<>();

        String temp = "";

        for(int i=0; i<input.length(); i++) {
            char now = input.charAt(i);

            if(now != '.')
                temp += now;
            else {
                list.add(temp);
                temp = "";
            }
        }

        list.add(temp);

        List<String> result = new ArrayList<>();

        for (String now : list) {
            if (now.length() % 2 == 1) {
                System.out.println(-1);
                return;
            }
            else {
                int num = now.length();
                String tmp = "";

                while(true) {
                    if(num >= 4) {
                        tmp += "AAAA";
                        num -= 4;
                    }
                    else if(num == 2) {
                        tmp += "BB";
                        num -= 2;
                    }

                    if(num == 0)
                        break;
                }

                result.add(tmp);
            }
        }

        String answer = "";

        for(int i=0; i<result.size(); i++) {
            answer += result.get(i);

            if(i != result.size()-1)
                answer += ".";
        }

        System.out.println(answer);
    }
}
