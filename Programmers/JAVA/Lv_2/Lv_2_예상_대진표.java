package Programmers.JAVA.Lv_2;

public class Lv_2_예상_대진표 {

    public int solution(int n, int a, int b)
    {
        int round = 0;

        while(a != b) {
            a = (a/2) + (a%2);
            b = (b/2) + (b%2);
            round++;
        }

        return round;
    }
}
