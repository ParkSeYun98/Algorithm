package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_6996_애너그램 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");

            String A = st.nextToken();
            String B = st.nextToken();

            int[] alphabetA = new int[54];
            int[] alphabetB = new int[54];

            for(int i=0; i<A.length(); i++)
                alphabetA[A.charAt(i) - 'a']++;

            for(int i=0; i<B.length(); i++)
                alphabetB[B.charAt(i) - 'a']++;

            System.out.print(A + " & " + B + " are ");

            boolean check = true;

            for(int i=0; i<alphabetA.length; i++) {
                if(alphabetA[i] != alphabetB[i]) {
                    check = false;
                    break;
                }
            }

            if(check)
                System.out.println("anagrams.");
            else
                System.out.println("NOT anagrams.");
        }
    }
}
