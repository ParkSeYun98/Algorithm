package SWEA.모의_SW_역량_테스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모의_SW_역량_테스트_2383_점심_식사시간 {
    private static int N;
    private static int min;

    private static Point[] stair;
    private static boolean[] sel;
    private static int[] dist;
    private static int[] onStair;
    private static boolean[] outStairFlag;

    private static int[][] room;

    private static List<Point> peopleList;

    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            stair = new Point[2];
            room = new int[N][N];
            peopleList = new ArrayList<>();

            int stairIdx = 0;

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for(int j=0; j<N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());

                    if(room[i][j] == 1)
                        peopleList.add(new Point(i, j));
                    else if(room[i][j] >= 2)
                        stair[stairIdx++] = new Point(i, j);
                }
            }

            sel = new boolean[peopleList.size()];
            min = Integer.MAX_VALUE;

            powerSet(0);

            System.out.println("#" + tc + " " + min);
        }
    }

    public static void powerSet(int depth) {
        if(depth == peopleList.size()) {
            getRoute();
            return;
        }

        sel[depth] = false;
        powerSet(depth+1);

        sel[depth] = true;
        powerSet(depth+1);
    }

    public static void getRoute() {
        dist = new int[peopleList.size()];
        onStair = new int[peopleList.size()];
        outStairFlag = new boolean[peopleList.size()];

        int cnt = divide(dist, onStair);

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        int minute = 0;

        while(cnt > 0) {
            minute++;

            if(minute >= min)
                return;

            // 리스트에 넣고 시간이 지남에 따라 줄어듬
            for(int i=0; i<Math.min(listA.size(), 3); i++) {
                onStair[listA.get(i)] = Math.max(onStair[listA.get(i)] - 1, 0);
                cnt--;
            }

            // 계단 위에서 시간 다 보냈으면 삭제
            for(int i=listA.size()-1; i>=0; i--) {
                if(onStair[listA.get(i)] == 0)
                    listA.remove(i);
            }

            // 리스트에 넣고 시간이 지남에 따라 줄어듬
            for(int i=0; i<Math.min(listB.size(), 3); i++) {
                onStair[listB.get(i)] = Math.max(onStair[listB.get(i)] - 1, 0);
                cnt--;
            }

            // 계단 위에서 시간 다 보냈으면 삭제
            for(int i=listB.size()-1; i>=0; i--) {
                if(onStair[listB.get(i)] == 0)
                    listB.remove(i);
            }

            for(int i=0; i<peopleList.size(); i++) {
                if(!outStairFlag[i]) {
                    if((listA.size()==3 && sel[i]|| (listB.size() == 3 && !sel[i])))
                        dist[i] = Math.max(dist[i]-1, 1);
                    else {
                        dist[i] = Math.max(dist[i]-1, 0);

                        if (dist[i] == 0 && sel[i]) {
                            outStairFlag[i] = true;
                            listA.add(i);
                        }
                        if (dist[i] == 0 && !sel[i]) {
                            outStairFlag[i] = true;
                            listB.add(i);
                        }
                    }
                }
            }
        }
        min = Math.min(min, minute);
    }

    public static int divide(int[] dist, int[] onStair) {
        int cnt = 0;

        for(int i=0; i<peopleList.size(); i++) {
            if(sel[i]) {
                dist[i] = getDistance(peopleList.get(i), stair[0]);
                onStair[i] = room[stair[0].x][stair[0].y];
            }
            else {
                dist[i] = getDistance(peopleList.get(i), stair[1]);
                onStair[i] = room[stair[1].x][stair[1].y];
            }

            cnt += onStair[i];
        }

        return cnt;
    }

    public static int getDistance(Point start, Point end) {
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y) + 1 ;
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
