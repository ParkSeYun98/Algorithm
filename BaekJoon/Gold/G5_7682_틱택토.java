package BaekJoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class G5_7682_틱택토 {

    static char bingoStatus;
    static int xBingoCnt = 0;
    static int oBingoCnt = 0;

    static int[] dr = {0, 1, 1, -1};
    static int[] dc = {1, 0, 1, 1};

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        board = new char[3][3];

        while(!(input = br.readLine()).equals("end")) {
            int xCnt = 0;
            int oCnt = 0;
            int emptyCnt = 0;

            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    char ch = input.charAt(3 * i + j);
                    board[i][j] = ch;

                    if(ch == 'X')
                        xCnt++;
                    else if(ch == 'O')
                        oCnt++;
                    else
                        emptyCnt++;
                }
            }

            StringBuilder sb = new StringBuilder();

            bingoCheck();

            // 빙고가 두번 일어날 수 없음
            if(xBingoCnt > 0 && oBingoCnt > 0) {
                System.out.println("invalid");
                continue;
            }

            // 빙고판이 가득 차 있을 때 (9칸이므로 X가 하나 더 많을 수 밖에 없다)
            if(emptyCnt == 0 && xCnt-oCnt == 1) {
                // 빙고판 가득 찼을 때는 O빙고 불가능
                if(oBingoCnt > 0)
                    sb.append("invalid").append('\n');
                else
                    sb.append("valid").append('\n');
            }
            // 빙고판이 가득 차 있지 않은 경우
            else {
                // X빙고
                if(xBingoCnt > 0 && xCnt-oCnt == 1)
                    sb.append("valid").append('\n');
                // O빙고
                else if(oBingoCnt > 0 && xCnt==oCnt)
                    sb.append("valid").append('\n');
                // 빙고가 없는데 빙고판이 가득 안차있을 때
                else
                    sb.append("invalid").append('\n');
            }

            sb.deleteCharAt(sb.length()-1);

            System.out.println(sb);
        }
    }

    static void bingoCheck() {
        xBingoCnt = 0;
        oBingoCnt = 0;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                char ch = board[i][j];

                if(ch == '.')
                    continue;

                outer : for(int d=0; d<4; d++) {
                    for(int k=0; k<3; k++) {
                        int nextR = i + (dr[d] * k);
                        int nextC = j + (dc[d] * k);

                        if(outOfMapCheck(nextR, nextC))
                            continue outer;

                        if(ch != board[nextR][nextC])
                            continue outer;
                    }

                    if(ch == 'O') {
                        bingoStatus = 'O';
                        oBingoCnt++;
                    }
                    else if(ch == 'X') {
                        bingoStatus = 'X';
                        xBingoCnt++;
                    }
                }
            }
        }
    }

    static boolean outOfMapCheck(int r, int c) {
        return r<0 || c<0 || r>=3 || c>=3;
    }

}
