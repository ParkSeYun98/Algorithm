package BaekJoon.Silver;

import java.io.*;
import java.util.StringTokenizer;

public class S1_16139_인간_컴퓨터_상호작용 {

    static int q;
    static String S;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        S = br.readLine();

        arr = new int[S.length()+1][26];

        for(int i=1; i<=S.length(); i++) {
            int now = S.charAt(i-1) - 'a';

            for(int j=0; j<26; j++) {
                int before = arr[i-1][j];

                if(j == now)
                    arr[i][j] = before + 1;
                else
                    arr[i][j] = before;
            }
        }

        q = Integer.parseInt(br.readLine());

        for(int i=0; i<q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.write((arr[r+1][a] - arr[l][a]) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
