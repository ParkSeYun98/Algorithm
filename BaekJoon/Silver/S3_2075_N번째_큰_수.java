package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_2075_N번째_큰_수 {

    static int N;

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        find();
    }

    static void find() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                pq.add(arr[i][j]);
        }

        int now = 0;

        for(int i=0; i<N; i++)
            now = pq.poll();

        System.out.println(now);
    }
}
