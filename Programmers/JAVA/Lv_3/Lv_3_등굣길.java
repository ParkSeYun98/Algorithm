package Programmers.JAVA.Lv_3;

class Lv_3_등굣길 {

    public final int TEMP = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];

        for(int i = 0; i < puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }

        map[1][1] = 1;

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(map[i][j] == -1)
                    continue;

                if(map[i-1][j] > 0)
                    map[i][j] += map[i-1][j] % TEMP;

                if(map[i][j-1] > 0)
                    map[i][j] += map[i][j-1] % TEMP;
            }
        }

        return map[n][m] % TEMP;
    }
}
