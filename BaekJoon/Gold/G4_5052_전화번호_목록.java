package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G4_5052_전화번호_목록 {

    static int n;

    static String[] phoneNumberArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++) {
            n = Integer.parseInt(br.readLine());

            phoneNumberArr = new String[n];

            for(int i=0; i<n; i++)
                phoneNumberArr[i] = br.readLine();

            Arrays.sort(phoneNumberArr);

            consistenceCheck();
        }
    }

    static void consistenceCheck() {
        for(int i=0; i<phoneNumberArr.length-1; i++) {
            if(phoneNumberArr[i+1].startsWith(phoneNumberArr[i])) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
