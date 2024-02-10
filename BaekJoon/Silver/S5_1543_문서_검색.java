package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1543_문서_검색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputA = br.readLine();
        String inputB = br.readLine();

        int idx = 0;
        int cnt = 0;
        boolean flag = false;

        for(int i=0; i<inputA.length(); i++) {
            idx = 0;

            if(flag) {
                i += inputB.length() - 1;
                flag = false;
            }
            
            for(int j=i; j<inputA.length(); j++) {
                if(idx == inputB.length()) {
                    flag = true;
                    break;
                }
                
                if(inputA.charAt(j) == inputB.charAt(idx))
                    idx++;
                else
                    break;
            }

            if(idx == inputB.length())
                cnt++;
        }

        System.out.println(cnt);
    }
}
