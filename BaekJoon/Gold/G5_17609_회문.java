package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_17609_회문 {

    static int T;
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            input = br.readLine();
            int flag = 2;

            StringBuilder sb = new StringBuilder(input);

            if(input.equals(sb.reverse().toString()))
                flag = 0;
            else {
                int left = 0;
                int right = input.length()-1;

                while(left < right) {
                    if(input.charAt(left) != input.charAt(right)) {
                        StringBuilder deleteLeft = new StringBuilder(input).deleteCharAt(left);
                        StringBuilder deleteRight = new StringBuilder(input).deleteCharAt(right);

                        if(check(deleteLeft) || check(deleteRight))
                            flag = 1;

                        break;
                    }

                    left++;
                    right--;
                }
            }

            ans.append(flag).append('\n');
        }

        ans.deleteCharAt(ans.length()-1);
        System.out.print(ans);
    }

    static boolean check(StringBuilder sb) {
        return sb.toString().equals(sb.reverse().toString());
    }
}