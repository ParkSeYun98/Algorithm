package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_6550_부분_문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            String input = br.readLine();

            if(input == null)
                break;

            st = new StringTokenizer(input, " ");

            String part = st.nextToken();
            String full = st.nextToken();

            int tmp = 0;
            int cnt = 0;

            for(int i=0; i<part.length(); i++) {
                for(int j=tmp; j<full.length(); j++) {
                    if(full.charAt(j) == part.charAt(i)) {
                        tmp = j+1;
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt == part.length())
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
