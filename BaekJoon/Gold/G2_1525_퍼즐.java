package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G2_1525_퍼즐 {

    static final String finalPuzzle = "123456780";

    static String initPuzzle = "";

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<3; j++)
                initPuzzle += st.nextToken();
        }

        map = new HashMap<>();
        map.put(initPuzzle, 0);

        solvePuzzle();
    }

    static void solvePuzzle() {
        Queue<String> queue = new LinkedList<>();
        queue.offer(initPuzzle);

        while(!queue.isEmpty()) {
            String now = queue.poll();
            int cnt = map.get(now);

            if(now.equals(finalPuzzle)) {
                System.out.println(cnt);
                return;
            }

            for(int d=0; d<4; d++) {
                int nextR = (now.indexOf("0") % 3) + dr[d];
                int nextC = (now.indexOf("0") / 3) + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                int nextP = nextR + nextC*3;
                char nextCh = now.charAt(nextP);
                String next = now.replace(nextCh, 'X');
                next = next.replace('0', nextCh);
                next = next.replace('X', '0');

                if(map.containsKey(next))
                    continue;

                queue.offer(next);
                map.put(next, cnt+1);
            }
        }

        System.out.println(-1);
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=3 || c>=3;
    }
}
