package BaekJoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_20006_랭킹전_대기열 {

    static int p, m;

    static Player[] arr;

    static class Player implements Comparable<Player> {
        int level;
        String nickname;
        boolean isMatched;

        public Player(int level, String nickname, boolean isMatched) {
            this.level = level;
            this.nickname = nickname;
            this.isMatched = isMatched;
        }


        @Override
        public int compareTo(Player o) {
            return this.nickname.compareTo(o.nickname);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new Player[p];

        for(int i=0; i<p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            arr[i] = new Player(level, nickname, false);
        }

        for(int i=0; i<p; i++) {
            List<Player> list = new ArrayList<>();

            if(arr[i].isMatched)
                continue;

            for(int j=i; j<p; j++) {
                if(list.size() == m)
                    break;

                Player now = arr[j];

                if(!now.isMatched && arr[i].level-10 <= now.level && arr[i].level+10 >= now.level) {
                    now.isMatched = true;
                    list.add(now);
                }
            }

            Collections.sort(list);

            if(list.size() == m)
                System.out.println("Started!");
            else
                System.out.println("Waiting!");

            for (Player player : list)
                System.out.println(player.level + " " + player.nickname);
        }
    }
}
