package Programmers.JAVA.Lv_2;

public class Lv_2_할인_행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int cnt = 0;

        for(int i=0; i<discount.length-9; i++) {
            int day = 0;

            for(int j=0; j<want.length; j++) {
                int temp = 0;

                for(int k=i; k<i+10; k++) {
                    if(discount[k].equals(want[j]))
                        temp++;
                }

                if(temp < number[j])
                    break;
                else
                    day++;
            }

            if(day == want.length)
                cnt++;
        }

        return cnt;
    }
}
