package Programmers.JAVA.Lv_2;

class Lv_2_방문_길이 {
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};

    class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(String dirs) {
        return findRoute(dirs);
    }

    int findRoute(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];

        int cnt = 0;

        Point now = new Point(5, 5);

        for(int i=0; i<dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int dirNum = getDir(dir);

            int nextR = now.r + dr[dirNum];
            int nextC = now.c + dc[dirNum];

            if(outOfMapCheck(nextR, nextC))
                continue;

            if(visited[nextR][nextC][dirNum]) {
                now = new Point(nextR, nextC);
                continue;
            }

            visited[nextR][nextC][dirNum] = true;
            visited[now.r][now.c][getCounterDir(dirNum)] = true;

            now = new Point(nextR, nextC);
            System.out.print(dir);
            cnt++;
        }

        return cnt;
    }

    public int getDir(char dir) {
        if(dir == 'U')
            return 3;
        else if(dir == 'D')
            return 2;
        else if(dir == 'L')
            return 1;
        else
            return 0;
    }

    public int getCounterDir(int dir) {
        if(dir == 0)
            return 1;
        else if(dir == 1)
            return 0;
        else if(dir == 2)
            return 3;
        else
            return 2;
    }

    public boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>10 || c>10;
    }
}