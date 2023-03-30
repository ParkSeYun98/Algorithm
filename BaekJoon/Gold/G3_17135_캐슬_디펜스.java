package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G3_17135_캐슬_디펜스 {
    private static int N;
    private static int M;
    private static int D;
    private static int killCnt;
    private static int killMax = Integer.MIN_VALUE;

    private static int[] archor;

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        archor = new int[3];

        Combination(0, 0);

        System.out.println(killMax);
    }

    // 조합 M개 자리에서 3자리 뽑기
    public static void Combination(int depth, int idx) {
        if(depth == 3) {
            int[][] copyMap = new int[N][M];

            for(int i=0; i<N; i++)
                copyMap[i] = map[i].clone();

            killCnt = 0;

            shoot();

            killMax = Math.max(killMax, killCnt);

            for(int i=0; i<N; i++)
                map[i] = copyMap[i].clone();

            return;
        }

        for(int i=idx; i<M; i++) {
            archor[depth] = i;
            Combination(depth+1, i+1);
        }
    }

    public static void shoot() {
        // 턴
        for(int i=0; i<N; i++) {
            boolean[][] visited = new boolean[N][M];

            // 궁수 세 명
            for(int j=0; j<3; j++) {
                int minDistance = Integer.MAX_VALUE;
                int minR = -1;
                int minC = -1;

                // 맵 체크
                for(int a=0; a<N; a++) {
                    for(int b=0; b<M; b++) {
                        if(map[a][b] == 1) {
                            int shootDistance = getDistance(a, b, j);

                            if(minDistance > shootDistance) {
                                minDistance = shootDistance;
                                minC = b;
                                minR = a;
                            }
                            // 만약 현재까지 최소 거리와 현재 좀비 거리가 같으면 두 위치의 X 좌표가 더 작은 곳으로
                            else if(minDistance == shootDistance) {
                                if(minC > b) {
                                    minC = b;
                                    minR = a;
                                }
                            }
                        }
                    }
                }

                // 최대 사격 거리 D보다 최소거리가 더 작으면 true로 체크
                // 한 좀비가 중복으로 한턴에 맞을 수 있기 때문에
                // 매 궁수 차례마다 죽이는게 아니라 한번에 죽임
                if(minDistance <= D)
                    visited[minR][minC] = true;
            }

            // 맵에서 true인 곳만 죽임
            for(int a=0; a<N; a++) {
                for(int b=0; b<M; b++) {
                    if(visited[a][b]) {
                        map[a][b] = 0;
                        killCnt++;
                    }
                }
            }

            // 턴이 끝나고 좀비 이동
            for(int a=N-1; a>=0; a--) {
                for(int b=0; b<M; b++) {
                    if(map[a][b] == 1) {
                        if(a == N-1)
                            map[a][b] = 0;
                        else {
                            map[a][b] = 0;
                            map[a+1][b] = 1;
                        }

                    }
                }
            }

            // 게임 종료 체크
            boolean flag = false;

            for(int a=0; a<N; a++) {
                for(int b=0; b<M; b++) {
                    if(map[a][b] == 1) {
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag)
                break;
        }
    }

    public static int getDistance(int x1, int y1, int archorIdx) {
        int x2 = N;
        int y2 = archor[archorIdx];

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
