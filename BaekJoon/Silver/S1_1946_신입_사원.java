package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S1_1946_신입_사원 {

    static int N;

    static List<Interview> list;

    static class Interview implements Comparable<Interview> {
        int score;
        int rank;

        public Interview(int score, int rank) {
            this.score = score;
            this.rank = rank;
        }

        @Override
        public int compareTo(Interview interview) {
            if(this.score > interview.score)
                return 1;
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int score = Integer.parseInt(st.nextToken());
                int rank = Integer.parseInt(st.nextToken());

                list.add(new Interview(score, rank));
            }

            Collections.sort(list);

            int cnt = 1;
            int min = list.get(0).rank;

            for(int i=1; i<N; i++) {
                if(list.get(i).rank < min) {
                    min = list.get(i).rank;
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
