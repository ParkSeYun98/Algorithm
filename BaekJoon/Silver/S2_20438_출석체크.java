package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2_20438_출석체크 {

    static int N, K, Q, M;

    static boolean[] student;
    static int[] prefixSum;

    static List<Integer> sleepList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sleepList = new ArrayList<>();
        student = new boolean[N+3];
        prefixSum = new int[N+3];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<K; i++)
            sleepList.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<Q; i++) {
            int now = Integer.parseInt(st.nextToken());

            if(sleepList.contains(now))
                continue;

            if(!student[now]) {
                for(int j=now; j<N+3; j++) {
                    if((j%now==0) && (!sleepList.contains(j)))
                        student[j] = true;
                }
            }
        }

        for(int i=3; i<prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1];

            if(!student[i])
                prefixSum[i]++;
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            System.out.println(prefixSum[E] - prefixSum[S-1]);
        }
    }
}
