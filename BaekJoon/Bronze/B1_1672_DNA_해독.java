package BaekJoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_1672_DNA_해독 {

    static char[] line = {'A', 'G', 'C', 'T'};

    static char[][] arr = {
            {'A', 'C', 'A', 'G'},
            {'C', 'G', 'T', 'A'},
            {'A', 'T', 'C', 'G'},
            {'G', 'A', 'G', 'T'}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        int num = charToInt(input.charAt(N-1));

        for (int i=N-1; i>0; i--) {
            int idx1 = charToInt(input.charAt(i-1));
            int idx2 = num;

            char now = arr[idx1][idx2];
            num = charToInt(now);
        }

        System.out.println(line[num]);
    }

    public static int charToInt(char c) {
        int num = 0;

        for (int i=0; i<4; i++) {
            if (c == line[i]) {
                num = i;
                break;
            }
        }

        return num;
    }
}
