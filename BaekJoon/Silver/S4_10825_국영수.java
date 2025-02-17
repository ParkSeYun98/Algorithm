package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S4_10825_국영수 {

    static class Score {
        String name;
        int A;
        int B;
        int C;

        public Score(String name, int A, int B, int C) {
            this.name = name;
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Score[] arr = new Score[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Score(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.A == o2.A) {
                if(o1.B == o2.B) {
                    if(o1.C == o2.C)
                        return o1.name.compareTo(o2.name);

                    return o2.C - o1.C;
                }

                return o1.B - o2.B;
            }

            return o2.A - o1.A;
        });

        for (Score now : arr)
            System.out.println(now.name);
    }
}
