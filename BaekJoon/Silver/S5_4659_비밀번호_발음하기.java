package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_4659_비밀번호_발음하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();

            if(input.equals("end"))
                break;

            boolean[] arr = new boolean[input.length()];

            boolean flag = false;

            for(int i=0; i<input.length(); i++) {
                char now = input.charAt(i);

                if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
                    arr[i] = true;
                    flag = true;
                }
            }

            System.out.print("<" + input + "> is ");

            boolean check = false;

            if(!flag)
                check = true;

            if(input.length() >= 3) {
                for(int j=2; j<arr.length; j++) {
                    if(arr[j] == arr[j-1] && arr[j-1] == arr[j-2]) {
                        check = true;
                        break;
                    }
                }
            }

            if(input.length() >= 2) {
                for(int j=1; j<arr.length; j++) {
                    char now = input.charAt(j);

                    if(now == 'e' || now == 'o')
                        continue;

                    if(now == input.charAt(j-1)) {
                        check = true;
                        break;
                    }
                }
            }

            if(check)
                System.out.print("not ");

            System.out.println("acceptable.");
        }
    }
}
