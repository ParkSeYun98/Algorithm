package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1025_제곱수_찾기 {

    static int N, M;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String input = br.readLine();

            for(int j=0; j<input.length(); j++)
                map[i][j] = input.charAt(j) - '0';
        }

        findNumber();
    }

    static void findNumber() {
        int ans = -1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {

                for(int spaceI=-N; spaceI<N; spaceI++) {
                    for(int spaceJ=-M; spaceJ<M; spaceJ++) {

                        // 등차수열의 공차가 행 열 둘다 0일 경우 서로 다른 칸을 고를 수 없다.
                        if(spaceI==0 && spaceJ==0)
                            continue;

                        // 초기값
                        int num = 0;
                        int nowR = i;
                        int nowC = j;

                        while(nowR>=0 && nowR<N && nowC>=0 && nowC<M) {
                            num = num*10 + map[nowR][nowC];

                            if(squareNumCheck(num))
                                ans = Math.max(ans, num);

                            nowR += spaceI;
                            nowC += spaceJ;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static boolean squareNumCheck(int num) {
        int sqrt = (int) Math.sqrt(num);

        return Math.pow(sqrt, 2) == num;
    }
}
