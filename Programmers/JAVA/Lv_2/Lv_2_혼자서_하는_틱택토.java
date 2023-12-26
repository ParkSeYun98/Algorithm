package Programmers.JAVA.Lv_2;

class Lv_2_혼자서_하는_틱택토 {
    public int solution(String[] board) {
        int OCnt = 0;
        int XCnt = 0;

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {
                char temp = board[i].charAt(j);

                if(temp == 'O')
                    OCnt++;
                else if(temp == 'X')
                    XCnt++;
            }
        }

        if(XCnt > OCnt)
            return 0;

        if(OCnt >= XCnt+2)
            return 0;

        if(finishCheck(board, 'O')) {
            if(OCnt == XCnt)
                return 0;
        }

        if(finishCheck(board, 'X')) {
            if(OCnt == XCnt+1)
                return 0;
        }

        return 1;
    }

    public boolean finishCheck(String[] board, char ox) {
        // 가로
        for(int i=0; i<board.length; i++) {
            boolean flag = true;

            for(int j=0; j<board[i].length(); j++) {
                char temp = board[i].charAt(j);

                if(temp != ox)
                    flag = false;
            }

            if(flag)
                return true;
        }

        // 세로
        for(int i=0; i<board.length; i++) {
            boolean flag = true;

            for(int j=0; j<board[i].length(); j++) {
                char temp = board[j].charAt(i);

                if(temp != ox)
                    flag = false;
            }

            if(flag)
                return true;
        }


        // 대각선 1
        boolean flag1 = true;

        for(int i=0; i<board.length; i++) {
            char temp = board[i].charAt(i);

            if(temp != ox)
                flag1 = false;
        }

        if(flag1)
            return true;

        // 대각선 2
        boolean flag2 = true;

        for(int i=0; i<board.length; i++) {
            char temp = board[board.length-i-1].charAt(i);

            if(temp != ox)
                flag2 = false;
        }

        if(flag2)
            return true;


        return false;
    }
}