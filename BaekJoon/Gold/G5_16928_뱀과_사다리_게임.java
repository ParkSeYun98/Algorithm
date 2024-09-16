package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G5_16928_뱀과_사다리_게임 {

    static int N, M, min;

    static Map<Integer, Integer> map;

    static class Game {
        int now;
        int cnt;

        public Game(int now, int cnt) {
            this.now = now;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.put(x, y);
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map.put(u, v);
        }

        BFS();

        System.out.println(min);
    }

    static void BFS() {
        Queue<Game> queue = new LinkedList<>();
        queue.offer(new Game(1, 0));

        boolean[] visited = new boolean[101];
        visited[1] = true;

        while(!queue.isEmpty()) {
            Game game = queue.poll();

            if(game.now == 100) {
                min = game.cnt;

                return;
            }


            for(int d=1; d<=6; d++) {
                int next = game.now + d;

                if(outOfBoardCheck(next))
                    continue;

                if(visited[next])
                    continue;

                if(map.containsKey(next))
                    next = map.get(next);

                queue.offer(new Game(next, game.cnt+1));
                visited[next] = true;
            }
        }
    }

    static boolean outOfBoardCheck(int num) {
        return num>100 || num<1;
    }
}
