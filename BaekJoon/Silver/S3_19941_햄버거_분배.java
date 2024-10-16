package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_19941_햄버거_분배 {

    static int N, K;

    static char[] trailer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        trailer = new char[N];
        visited = new boolean[N];

        for(int i=0; i<input.length(); i++)
            trailer[i] = input.charAt(i);

        int cnt = 0;

        outer : for(int i=0; i<N; i++) {
            if(trailer[i] == 'P') {
                for(int j=i-K; j<=i-1; j++) {
                    if(j < 0)
                        continue;

                    if (trailer[j] == 'H' && !visited[j]) {
                        visited[j] = true;
                        cnt++;
                        continue outer;
                    }
                }

                for(int k=i+1; k<=i+K; k++) {
                    if(k >= N)
                        continue;

                    if(trailer[k] == 'H' && !visited[k]) {
                        visited[k] = true;
                        cnt++;
                        continue outer;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
