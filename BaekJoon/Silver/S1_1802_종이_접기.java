package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_1802_종이_접기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            String input = br.readLine();

            if(check(0, input.length()-1, input))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static boolean check(int start, int end, String input) {
        if(start == end)
            return true;

        int mid = (start + end) / 2;

        for(int i=start; i<mid; i++) {
            if(input.charAt(i) == input.charAt(end - i))
                return false;
        }

        if(check(start, mid-1, input) && check(mid+1, end, input))
            return true;
        else
            return false;
    }
}
