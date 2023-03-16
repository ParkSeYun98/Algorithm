package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_1759_암호_만들기 {
    private static int L;
    private static int C;

    private static String[] alphabet;
    private static boolean[] visited;
    private static String[] arr;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alphabet = new String[C];
        visited = new boolean[C];
        arr = new String[L];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<C; i++)
            alphabet[i] = st.nextToken();

        Arrays.sort(alphabet);

        DFS(0, 0);

        System.out.println(sb.toString());
    }

    public static void DFS(int depth, int start) {
        if(depth == L) {
            if(check()) {
                for(String str : arr)
                    sb.append(str);
                sb.append('\n');
            }

            return;
        }

        for(int i=start; i<=C-L+depth; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = alphabet[i];
                DFS(depth + 1, i+1);
                visited[i] = false;
            }
        }
    }

    public static boolean check() {
        String[] aeiou = {"a", "e", "i", "o", "u"};
        int cnt = 0;

        for(int i=0; i<arr.length; i++) {
            for (int j = 0; j < aeiou.length; j++) {
                if (arr[i].equals(aeiou[j]))
                    cnt++;
            }
        }

        return cnt >= 1 && arr.length - cnt >= 2;
    }
}
