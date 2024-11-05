package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_11328_Strfry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            int[] arr1 = new int[26];
            int[] arr2 = new int[26];

            for(int i=0; i<str1.length(); i++)
                arr1[str1.charAt(i) - 'a']++;

            for(int i=0; i<str2.length(); i++)
                arr2[str2.charAt(i) - 'a']++;

            boolean flag = true;

            for(int i=0; i<arr1.length; i++) {
                if(arr1[i] != arr2[i]) {
                    flag = false;
                    break;
                }
            }

            if(!flag)
                System.out.println("Impossible");
            else
                System.out.println("Possible");
        }
    }
}
