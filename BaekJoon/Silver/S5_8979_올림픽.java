package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S5_8979_올림픽 {

    static int N;
    static int K;

    static List<Medal> medalList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        medalList = new ArrayList<>();

        for(int i=1; i<=N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medalList.add(new Medal(-1, idx, gold, silver, bronze));
        }

        Collections.sort(medalList);

        for(int i=0; i<medalList.size(); i++) {
            medalList.get(i).rank = i+1;

            if(i != 0) {
                Medal now = medalList.get(i);
                Medal before = medalList.get(i-1);

                if(now.gold == before.gold && now.silver == before.silver && now.bronze == before.bronze)
                    now.rank = before.rank;

            }
        }

        for(int i=0; i<medalList.size(); i++) {
            if(medalList.get(i).idx == K)
                System.out.println(medalList.get(i).rank);
        }
    }

    static class Medal implements Comparable<Medal> {

        int rank;
        int idx;
        int gold;
        int silver;
        int bronze;

        public Medal(int rank, int idx, int gold, int silver, int bronze) {

            this.rank = rank;
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal m) {
            if(this.gold == m.gold) {
                if(this.silver == m.silver) {
                    return m.bronze - this.bronze;
                }
                else
                    return m.silver - this.silver;
            }
            else
                return m.gold - this.gold;
        }
    }
}
