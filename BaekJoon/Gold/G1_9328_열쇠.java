/*
* Memory : 24660 KB
* Time : 240 ms
* */

package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G1_9328_열쇠 {

    private static int h;
    private static int w;
    private static int count;

    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};

    private static char[][] map;

    private static List<Character> keyList;
    private static List<Point> doorList;
    private static List<Point> startList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            count = 0;
            map = new char[h][w];
            keyList = new ArrayList<>();
            doorList = new ArrayList<>();
            startList = new ArrayList<>();

            for(int i=0; i<h; i++) {
                String temp = br.readLine();

                for(int j=0; j<temp.length(); j++) {
                    map[i][j] = temp.charAt(j);

                    if(i==0 || i==h-1 || j==0 || j==w-1) {
                        if(map[i][j] == '.')
                            startList.add(new Point(i, j));
                        else if(map[i][j] >= 'a' && map[i][j] <= 'z') {
                            startList.add(new Point(i, j));
                            keyList.add(map[i][j]);
                        }
                        else if(map[i][j] >= 'A' && map[i][j] <= 'Z')
                            doorList.add(new Point(i, j));
                        else if(map[i][j] == '$') {
                            startList.add(new Point(i, j));
                            count++;
                        }
                    }
                }
            }

            String temp = br.readLine();

            if(!temp.equals("0")) {
                for(int i=0; i<temp.length(); i++)
                    keyList.add(temp.charAt(i));
            }

            for(int i=0; i<doorList.size(); i++) {
                Point doorPoint = doorList.get(i);

                for(int j=0; j<keyList.size(); j++) {
                    if((char)(map[doorPoint.r][doorPoint.c]+32) == keyList.get(j))
                        startList.add(doorPoint);
                }
            }

            BFS();

            System.out.println(count);
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        for (Point startPoint : startList) {
            queue.offer(startPoint);
            visited[startPoint.r][startPoint.c] = true;
        }

        while(!queue.isEmpty()) {
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nextR = now.r + dr[d];
                int nextC = now.c + dc[d];

                if(outOfMapCheck(nextR, nextC))
                    continue;

                if(wallCheck(nextR, nextC))
                    continue;

                if(visited[nextR][nextC])
                    continue;

                if(map[nextR][nextC] >= 'a' && map[nextR][nextC] <= 'z') {
                    queue.offer(new Point(nextR, nextC));
                    visited[nextR][nextC] = true;
                    keyList.add(map[nextR][nextC]);

                    for (Point doorPoint : doorList) {
                        if((map[doorPoint.r][doorPoint.c] == map[nextR][nextC] - 32) && (!visited[doorPoint.r][doorPoint.c])) {
                            queue.offer(doorPoint);
                            visited[doorPoint.r][doorPoint.c] = true;
                        }
                    }
                }
                else if(map[nextR][nextC] >= 'A' && map[nextR][nextC] <= 'Z') {
                    for (Character key : keyList) {
                        if(key - 32 == map[nextR][nextC]) {
                            queue.offer(new Point(nextR, nextC));
                            visited[nextR][nextC] = true;
                        }
                        else
                            doorList.add(new Point(nextR, nextC));
                    }

                    if(keyList.isEmpty())
                        doorList.add(new Point(nextR, nextC));
                }
                else {
                    queue.offer(new Point(nextR, nextC));
                    visited[nextR][nextC] = true;

                    if(map[nextR][nextC] == '$')
                        count++;
                }
            }
        }
    }

    public static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=h || c>=w;
    }

    public static boolean wallCheck(int r, int c) {
        return map[r][c] == '*';
    }

    public static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
