/*
* Memory : 11584 KB
* Time : 80 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class G4_1339_단어_수학 {

    private static int N;
    private static int idx = 9;
    private static int cnt = 0;

    private static String[] vocaArr;
    private static Integer[] alphabet;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        vocaArr = new String[N];
        alphabet = new Integer[26];

        Arrays.fill(alphabet, 0);

        for (int i = 0; i < N; i++)
            vocaArr[i] = br.readLine();

        for(int i=0; i<N; i++) {
            int index = (int) Math.pow(10, vocaArr[i].length() - 1);

            for(int j=0; j<vocaArr[i].length(); j++) {
                int now = vocaArr[i].charAt(j);

                alphabet[now - 65] += index;
                index /= 10;
            }
        }

        Arrays.sort(alphabet, Collections.reverseOrder());

        for(int i=0; i<alphabet.length; i++) {
            if(alphabet[i] == 0)
                break;

            cnt += alphabet[i] * idx--;
        }

        System.out.println(cnt);
    }
}
