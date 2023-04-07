package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class G4_17140_이차원_배열과_연산 {
    static int r;
    static int c;
    static int k;

    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        A = new int[3][3];

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<3; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        timeGoesOn();
    }

    static void timeGoesOn() {
        int t = 0;

        while(true) {
            if(A.length>r && A[0].length>c && A[r][c] == k) {
                System.out.println(t);
                return;
            }

            if(t==100) {
                System.out.println(-1);
                return;
            }

            if(A.length > 100 && A[0].length <= 100) {
                int[][] ACopy = new int[100][A[0].length];
                for(int i=0; i<ACopy.length; i++)
                    ACopy[i] = A[i].clone();

                A = new int[100][ACopy[0].length];
                for(int i=0; i<A.length; i++)
                    A[i] = ACopy[i].clone();
            }
            else if(A.length <= 100 && A[0].length > 100) {
                int[][] ACopy = new int[A.length][100];
                for(int i=0; i<ACopy.length; i++)
                    ACopy[i] = A[i].clone();

                A = new int[ACopy.length][100];
                for(int i=0; i<A.length; i++)
                    A[i] = ACopy[i].clone();
            }
            else if(A.length > 100 && A[0].length > 100) {
                int[][] ACopy = new int[100][100];
                for(int i=0; i<100; i++)
                    ACopy[i] = A[i].clone();

                A = new int[100][100];
                for(int i=0; i<100; i++)
                    A[i] = ACopy[i].clone();
            }

            if(RCCheck())
                R();
            else
                C();

            t++;
        }
    }

    static boolean RCCheck() {
        return A.length >= A[0].length;
    }

    static void R() {
        PriorityQueue<Pair>[] pq = new PriorityQueue[A.length];
        for(int i=0; i<A.length; i++)
            pq[i] = new PriorityQueue<>();

        for(int i=0; i<A.length; i++) {
            Map<Integer, Integer> tempMap = new HashMap<>();

            int lineMax = -1;
            for(int j=0; j<A[i].length; j++)
                lineMax = Math.max(lineMax, A[i][j]);

            int[] lineCount = new int[lineMax+1];
            for(int j=0; j<A[i].length; j++) {
                if(A[i][j] == 0)
                    continue;
                lineCount[A[i][j]]++;
            }

            for(int j=0; j<lineCount.length; j++) {
                if(lineCount[j] == 0)
                    continue;
                tempMap.put(j, lineCount[j]);
            }

            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(tempMap.entrySet());
            for(Map.Entry<Integer, Integer> entry : entryList)
                pq[i].offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int maxSize = -1;
        for(int i=0; i<A.length; i++)
            maxSize = Math.max(maxSize, pq[i].size()*2);

        A = new int[A.length][maxSize];

        for(int i=0; i<A.length; i++) {
            int j=0;

            while(!pq[i].isEmpty()) {
                Pair next = pq[i].poll();
                A[i][j] = next.num;
                j++;
                A[i][j] = next.cnt;
                j++;
            }
        }
    }

    static void C() {
        PriorityQueue<Pair>[] pq = new PriorityQueue[A[0].length];
        for(int i=0; i<A[0].length; i++)
            pq[i] = new PriorityQueue<>();

        for(int i=0; i<A[0].length; i++) {
            Map<Integer, Integer> tempMap = new HashMap<>();

            int lineMax = -1;
            for(int j=0; j<A.length; j++)
                lineMax = Math.max(lineMax, A[j][i]);

            int[] lineCount = new int[lineMax+1];
            for(int j=0; j<A.length; j++) {
                if(A[j][i] == 0)
                    continue;
                lineCount[A[j][i]]++;
            }

            for(int j=0; j<lineCount.length; j++) {
                if(lineCount[j] == 0)
                    continue;
                tempMap.put(j, lineCount[j]);
            }

            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(tempMap.entrySet());
            for(Map.Entry<Integer, Integer> entry : entryList)
                pq[i].offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int maxSize = -1;
        for(int i=0; i<A[0].length; i++)
            maxSize = Math.max(maxSize, pq[i].size()*2);

        A = new int[maxSize][A[0].length];

        for(int i=0; i<A[0].length; i++) {
            int j=0;

            while(!pq[i].isEmpty()) {
                Pair next = pq[i].poll();
                A[j][i] = next.num;
                j++;
                A[j][i] = next.cnt;
                j++;
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.cnt > o.cnt)
                return this.cnt - o.cnt;
            else if(this.cnt == o.cnt)
                return this.num - o.num;
            else
                return -1;
        }
    }
}
