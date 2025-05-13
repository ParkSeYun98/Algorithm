package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1283_단축키_지정 {

    static int N;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[26];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++) {
            String input = br.readLine();
            String str = checkFirst(input);

            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    static String checkFirst(String input) {
        String[] vocaArr = input.split(" ");

        for(int j=0; j<vocaArr.length; j++) {
            char alphabet = vocaArr[j].charAt(0);

            if(alphabet>='A' && alphabet<='Z')
                alphabet = (char) ('a' + (alphabet-'A'));

            if(!visited[alphabet-'a']) {
                visited[alphabet-'a'] = true;

                return checkSecond(vocaArr, j);
            }
        }

        for(int j=1; j<input.length(); j++) {
            if(input.charAt(j)==' ') {
                j++;
                continue;
            }

            char alphabet = input.charAt(j);

            if(alphabet>='A' && alphabet<='Z')
                alphabet = (char) ('a' + (alphabet-'A'));

            if(!visited[alphabet-'a']) {
                visited[alphabet-'a'] = true;

                return checkSecond(input, j);
            }
        }

        return input;
    }

    static String checkSecond(String[] wordArr, int idx) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<wordArr.length; i++) {
            String word = wordArr[i];

            if(idx == i) {
                sb.append("[").append(word.charAt(0)).append("]");
                sb.append(word.substring(1)).append(" ");
            }
            else
                sb.append(wordArr[i]).append(" ");
        }

        return sb.toString();
    }

    static String checkSecond(String input, int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(input, 0, idx);
        sb.append("[").append(input.charAt(idx)).append("]");
        sb.append(input.substring(idx+1));

        return sb.toString();
    }
}
