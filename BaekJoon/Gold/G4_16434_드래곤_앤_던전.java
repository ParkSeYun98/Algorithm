package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_16434_드래곤_앤_던전 {

    static int N;

    static Room[] roomArr;

    static class Room {
        long t;
        long a;
        long h;

        public Room(long t, long a, long h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        long atk = Long.parseLong(st.nextToken());

        roomArr = new Room[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long t = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long h = Long.parseLong(st.nextToken());

            roomArr[i] = new Room(t, a, h);
        }

        BinarySearch(atk);
    }

    static void BinarySearch(long atk) {
        long left = 0;
        long right = Long.MAX_VALUE;

        while(left <= right) {
            long mid = (left+right) / 2;

            if(game(atk, mid))
                right = mid-1;
            else
                left = mid+1;
        }

        System.out.println(left);
    }

    static boolean game(long atk, long maxHP) {
        long nowHP = maxHP;

        for (Room room : roomArr) {
            if(room.t == 1L) {
                if((room.h % atk) == 0L)
                    nowHP -= (room.h/atk - 1) * room.a;
                else
                    nowHP -= (room.h/atk) * room.a;

                if(nowHP <= 0)
                    return false;
            }

            else if (room.t == 2L) {
                atk += room.a;
                nowHP += room.h;

                if(nowHP > maxHP)
                    nowHP = maxHP;
            }
        }

        return true;
    }
}
