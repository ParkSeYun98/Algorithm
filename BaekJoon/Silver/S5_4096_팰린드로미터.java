package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_4096_팰린드로미터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = null;

        while(!(input = br.readLine()).equals("0")) {
            int result = 0;
            int size = input.length();
            int num = Integer.parseInt(input);

            while(true) {
                boolean flag = false;

                String str = String.valueOf(num);
                StringBuilder sb = new StringBuilder();

                for(int i=str.length(); i<size; i++)
                    sb.append("0");
                sb.append(str);

                str = sb.toString();

                for(int i=0; i<str.length()/2; i++) {
                    if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                        num++;
                        result++;
                        flag = true;
                        break;
                    }
                }

                if(!flag) {
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
