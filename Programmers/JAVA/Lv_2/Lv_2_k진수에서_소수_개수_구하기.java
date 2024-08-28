package Programmers.JAVA.Lv_2;

public class Lv_2_k진수에서_소수_개수_구하기 {

    public int solution(int n, int k) {
        int cnt = 0;
        String num = Integer.toString(n, k);
        String[] arr = num.split("0");

        for(int i=0; i<arr.length; i++) {
            String now = arr[i];

            if(now.equals(""))
                continue;

            if(primeCheck(Long.parseLong(now)))
                cnt++;
        }

        return cnt;
    }

    public boolean primeCheck(long num) {
        if(num < 2)
            return false;

        if(num%2 == 0)
            return (num == 2);

        for(int i=3; i<=Math.sqrt(num); i+=2) {
            if(num%i == 0)
                return false;
        }

        return true;
    }
}
