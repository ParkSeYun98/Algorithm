package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_16943_숫자_재배치 {

    static int max, target;

    static int[] num, result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

         st = new StringTokenizer(br.readLine()," ");
         String input = st.nextToken();
         num = new int[input.length()];

         for(int i=0; i<input.length(); i++)
             num[i] = input.charAt(i) - '0';

         target = Integer.parseInt(st.nextToken());

         max = 0;
         visited = new boolean[input.length()];

         DFS(0, 0);

         if(max == 0)
             System.out.println(-1);
         else
             System.out.println(max);
    }

    static void DFS(int depth, int partSum) {
        if(depth == num.length) {
            max = Math.max(max, partSum);
            return;
        }

        for(int i=0; i<num.length; i++) {
            if(visited[i])
                continue;

            if((depth == 0) && (num[i] == 0))
                continue;

            int tmp = 10 * partSum + num[i];

            if(tmp > target)
                continue;

            visited[i] = true;
            DFS(depth+1, tmp);
            visited[i] = false;
        }
    }
}
