package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_17779_게리맨더링_2 {
    static int N;
    static int min = Integer.MAX_VALUE;

    // 우상 우하
    static final int[] dr = {1, 1};
    static final int[] dc = {-1, 1};

    static int[] d;
    static boolean[] visited;

    static int[][] city;
    static int[][] dividedCity;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        d = new int[2];
        visited = new boolean[N-1];
        city = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1; j<=N; j++)
                city[i][j] = Integer.parseInt(st.nextToken());
        }

        checkCondition();

        System.out.println(min);
    }

    static void checkCondition() {
        for(int x=1; x<=N; x++) {
            for(int y=1; y<=N; y++) {
                for(int d1=1; d1<=N; d1++) {
                    for(int d2=1; d2<=N; d2++) {
                        if(boundCheck(x, y, d1, d2)) {
                            dividedCity = new int[N+2][N+2];
                            division(x, y, d1, d2);
                        }
                    }
                }
            }
        }
    }

    static void division(int x, int y, int d1, int d2) {
        // 5번 선거구의 경계선 먼저 생성

        for(int d=0; d<=d1; d++) {
            int nr = x + dr[0]*d;
            int nc = y + dc[0]*d;

            dividedCity[nr][nc] = 5;
        }

        for(int d=0; d<=d2; d++) {
            int nr = x + dr[1]*d;
            int nc = y + dc[1]*d;

            dividedCity[nr][nc] = 5;
        }

        for(int d=0; d<=d2; d++) {
            int nr = x + d1 + dr[1]*d;
            int nc = y - d1 + dc[1]*d;

            dividedCity[nr][nc] = 5;
        }

        for(int d=0; d<=d1; d++) {
            int nr = x + d2 + dr[0]*d;
            int nc = y + d2 + dc[0]*d;

            dividedCity[nr][nc] = 5;
        }

        int[] sum = new int[5];

        // 1구역
        for(int i=1; i<x+d1; i++) {
            for(int j=1; j<=y; j++) {
                if(dividedCity[i][j] == 5)
                    break;

                sum[0] += city[i][j];
            }
        }
        
        // 2구역
        for(int i=1; i<=x+d2; i++) {
            for(int j=N; j>y; j--) {
                if(dividedCity[i][j] == 5)
                    break;

                sum[1] += city[i][j];
            }
        }
        
        // 3구역
        for(int i=N; i>=x+d1; i--) {
            for(int j=1; j<y-d1+d2; j++) {
                if(dividedCity[i][j] == 5)
                    break;

                sum[2] += city[i][j];
            }
        }
        
        // 4구역
        for(int i=N; i>x+d2; i--) {
            for(int j=N; j>=y-d1+d2; j--) {
                if(dividedCity[i][j] == 5)
                    break;

                sum[3] += city[i][j];
            }
        }

        
        // 5구역
        int partSum = 0;
        for(int i=0; i<4; i++)
            partSum += sum[i];

        int allSum = 0;
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++)
                allSum += city[i][j];
        }

        sum[4] = allSum - partSum;

        Arrays.sort(sum);

        min = Math.min(min, sum[4] - sum[0]);
    }

    static boolean boundCheck(int x, int y, int d1, int d2) {
        return x + d1 <= N && y - d1 > 0 && x + d2 <= N && y + d2 <= N && x + d1 + d2 <= N && y - d1 + d2 <= N;
    }
}
