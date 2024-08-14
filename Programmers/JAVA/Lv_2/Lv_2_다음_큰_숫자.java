package Programmers.JAVA.Lv_2;

public class Lv_2_다음_큰_숫자 {

    public int solution(int n) {
        int cnt = 0;
        int oneCnt = 0;

        String binaryStr = Integer.toBinaryString(n);

        oneCnt = binaryStr.length() - binaryStr.replace("1", "").length();

        while(true) {
            if(oneCnt == cnt)
                break;

            String nowBinaryStr = Integer.toBinaryString(++n);

            cnt = nowBinaryStr.length() - nowBinaryStr.replace("1", "").length();
        }

        return n;
    }
}
