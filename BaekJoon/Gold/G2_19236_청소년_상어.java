package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G2_19236_청소년_상어 {

    static int max;

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

    static int[][] ocean;

    static List<Fish> fishList;

    static class Fish {
        int r;
        int c;
        int num;
        int dir;
        boolean alive;

        public Fish(int r, int c, int num, int dir, boolean alive) {
            this.r = r;
            this.c = c;
            this.num = num;
            this.dir = dir;
            this.alive = alive;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        max = Integer.MIN_VALUE;
        ocean = new int[4][4];
        fishList = new ArrayList<>();

        for(int i=0; i<4; i++) {
            st = new StringTokenizer(br.readLine() , " ");

            for(int j=0; j<4; j++) {
                int fishNum = Integer.parseInt(st.nextToken());
                int fishDir = Integer.parseInt(st.nextToken());

                Fish fish = new Fish(i, j, fishNum, fishDir-1, true);

                ocean[i][j] = fishNum;
                fishList.add(fish);
            }
        }

        fishList.sort((o1, o2) -> o1.num - o2.num);
        Fish deadFish = fishList.get(ocean[0][0]-1);
        fishList.set(ocean[0][0]-1, new Fish(0, 0, deadFish.num, deadFish.dir, false));

        DFS(deadFish.num, 0, 0);

        System.out.println(max);
    }

    static void DFS(int eatCnt, int sharkR, int sharkC) {
        max = Math.max(max, eatCnt);

        for (Fish fish : fishList) {
            if(!fish.alive)
                continue;

            Print();
            switchFish(fish, sharkR, sharkC);
        }
        Print();

        Fish shark = fishList.get(ocean[sharkR][sharkC] - 1);

        for(int i=1; i<=3; i++) {
            int nextR = sharkR + (dr[shark.dir] * i);
            int nextC = sharkC + (dc[shark.dir] * i);

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(!fishCheck(nextR, nextC))
                continue;

            Fish nextFish = fishList.get(ocean[nextR][nextC] - 1);

            fishList.set(ocean[nextR][nextC]-1, new Fish(nextR, nextC, nextFish.num, nextFish.dir, false));
            DFS(eatCnt + nextFish.num, nextR, nextC);
            fishList.set(ocean[nextR][nextC]-1, new Fish(nextR, nextC, nextFish.num, nextFish.dir, true));
        }
    }

    static void switchFish(Fish fish, int sharkR, int sharkC) {
        for(int d=0; d<8; d++) {
            int nextDir = (fish.dir + d) % 8;
            int nextR = fish.r + dr[nextDir];
            int nextC = fish.c + dc[nextDir];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(sharkCheck(nextR, nextC, sharkR, sharkC))
                continue;

            Fish nextFish = fishList.get(ocean[nextR][nextC]-1);
            fishList.set(fish.num-1, new Fish(nextR, nextC, fish.num, nextDir, fish.alive));
            fishList.set(nextFish.num-1, new Fish(fish.r, fish.c, nextFish.num, nextFish.dir, nextFish.alive));

            int temp = ocean[fish.r][fish.c];
            ocean[fish.r][fish.c] = ocean[nextR][nextC];
            ocean[nextR][nextC] = temp;

            return;
        }
    }

    static void rotate() {

    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=4 || c>=4;
    }

    static boolean sharkCheck(int r, int c, int sharkR, int sharkC) {
       return r == sharkR && c == sharkC;
    }

    static boolean fishCheck(int r, int c) {
        return fishList.get(ocean[r][c] - 1).alive;
    }

    static void Print() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++)
                System.out.print(ocean[i][j] + " ");
            System.out.println();
        }
        System.out.println();

//        for (Fish fish : fishList) {
//            System.out.println(fish.num + " : " + fish.dir);
//        }
//        System.out.println();
    }
}
