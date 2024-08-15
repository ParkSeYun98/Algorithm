package Programmers.JAVA.Lv_2;

public class Lv_2_n2_배열_자르기 {

    public int[] solution(int n, long left, long right) {
        int len = (int)right - (int)left;

        int[] answer = new int[len+1];

        int idx = 0;

        for (long i=left; i<=right; i++) {
            long row = i/n;
            long col = i%n;

            answer[idx++] = Math.max((int)row, (int)col) + 1;
        }

        return answer;
    }
}
