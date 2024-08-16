package Programmers.JAVA.Lv_2;

public class Lv_2_피보나치_수 {

    public int solution(int n) {
        int answer = 0;

        int[] fibonacci = new int[n+1];

        fibonacci[0] = 0;
        fibonacci[1] = 1;

        for(int i=2; i<=n; i++)
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % 1234567;

        return fibonacci[n];
    }
}
