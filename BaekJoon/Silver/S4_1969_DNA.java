package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_1969_DNA {

    static int N, M;

    static String[] DNA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DNA = new String[N];

        for(int i=0; i<N; i++)
            DNA[i] = br.readLine();

        int HammingDistance = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            int[] cnt = new int[4];

            for(int j=0; j<N; j++) {
                char now = DNA[j].charAt(i);

                switch(now) {
                    case 'A' :
                        cnt[0]++;
                        break;
                    case 'C' :
                        cnt[1]++;
                        break;
                    case 'G' :
                        cnt[2]++;
                        break;
                    case 'T' :
                        cnt[3]++;
                        break;
                }
            }

            int maxIdx = 0;
            int max = 0;

            for (int k=0; k<4; k++) {
                if (cnt[k] > max || (cnt[k] == max && k < maxIdx)) {
                    max = cnt[k];
                    maxIdx = k;
                }
            }

            switch(maxIdx) {
                case 0 :
                    sb.append('A');
                    break;
                case 1 :
                    sb.append('C');
                    break;
                case 2 :
                    sb.append('G');
                    break;
                case 3 :
                    sb.append('T');
            }

            HammingDistance += (N - max);
        }

        System.out.println(sb);
        System.out.println(HammingDistance);
    }
}
